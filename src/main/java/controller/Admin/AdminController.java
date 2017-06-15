package controller.Admin;

import model.CommentEntity;
import model.FrameEntity;
import model.ManagerEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.AdminService.IAdminService;
import service.AdminService.Impl.AdminServiceImpl;
import service.SearchService.ISearchService;
import service.SearchService.Impl.SearchServiceImpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by joy12 on 2017/6/8.
 */
@Controller
public class AdminController {
    @Resource
    private IAdminService adminService = new AdminServiceImpl();

    @RequestMapping(value = "/jsp/admin/adminLogin",method = RequestMethod.POST)
    @ResponseBody
    public Map adminLogin(HttpServletRequest request){
        Map result = new HashMap();
        String msg = "系统正忙，请稍后再试";
        String loginAccount = request.getParameter("login_account");
        String loginPassword = request.getParameter("login_password");

        System.out.println("AdminController: 开始登录");
        System.out.println("loginAccount: " + loginAccount);
        System.out.println("loginPassword: " + loginPassword);

        Map ret = adminService.adminLogin(loginAccount,loginPassword);
        int retcode = Integer.parseInt(ret.get("retcode").toString());
        System.out.println("retcode: " + retcode);
        if (retcode == 2){
            msg = "该管理员不存在";
        }else if (retcode == 1){
            msg = "密码错误";
        }else if (retcode == 0){
            //将用户信息存入session
            ManagerEntity manager = (ManagerEntity) ret.get("managerInfo");
            request.getSession().setAttribute("managerInfo",manager);
            msg = "管理员 " + manager.getManagerName() + " 登陆成功";
        }
        result.put("retcode",retcode);
        result.put("msg",msg);
        return result;
    }

    @RequestMapping(value = "/jsp/admin/adminUnlogin",method = RequestMethod.POST)
    @ResponseBody
    public void unlogin(HttpServletRequest request){
        if (request.getSession().getAttribute("managerInfo") != null){
            System.out.println("UserBasicController: 开始注销");
            request.getSession().removeAttribute("managerInfo");
        }
    }

    @RequestMapping(value = "/jsp/admin_single_item")
    public ModelAndView toAdminSingleItem(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin_single_item");
        Integer frameId = Integer.parseInt(request.getParameter("frameId"));

        FrameEntity frameInfo = adminService.getAdminFrameByFrameId(frameId);
        if (frameInfo != null){
            mv.addObject("msg","success");
            mv.addObject("frameInfo",frameInfo);
            List<CommentEntity> commentList = adminService.getAdminAllCommentsByFrameId(frameId);
            mv.addObject("commentList",commentList);
            System.out.println("找到关于frameId：" + frameId + "的" + commentList.size() + "条评论");
        }else{
            mv.addObject("msg","failure");
        }

        return mv;
    }

    @RequestMapping(value = "/jsp/admin/itemWithdraw",method = RequestMethod.POST)
    @ResponseBody
    public Map itemWithdraw(HttpServletRequest request){
        Map result = new HashMap();
        int retcode;
        String msg = "下架成功";
        ManagerEntity managerEntity = (ManagerEntity) request.getSession().getAttribute("managerInfo");
        //未登录的情况
        if (managerEntity == null){
            retcode = -1;
            msg = "您没有权限下架货品，请检查是否以管理员身份登录";
        }else{
            Integer frameId = Integer.parseInt(request.getParameter("frameId"));
            System.out.println("AdminController: 开始删除货品 frame: " + frameId);
            retcode = adminService.deleteFrame(frameId);
            if (retcode == 1){
                msg = "货物已下架";
            }
        }

        result.put("retcode",retcode);
        result.put("msg",msg);
        return result;
    }

    @RequestMapping(value = "/jsp/admin/itemAdd",method = RequestMethod.POST)
    public ModelAndView itemAdd(HttpServletRequest request, @RequestParam("itemImg") CommonsMultipartFile imgFile){
        ModelAndView mv = new ModelAndView("redirect:../index");
        int retcode;
        String msg;
        ManagerEntity managerEntity = (ManagerEntity) request.getSession().getAttribute("managerInfo");
        //未登录的情况
        if (managerEntity == null){
            retcode = -1;
            msg = "您没有权限上架货品，请检查是否以管理员身份登录";
        }else{
            String frameName = request.getParameter("itemName");
            String framePrice = request.getParameter("itemPrice");
            String userType = request.getParameter("userType");
            String glassesType = request.getParameter("glassesType");
            String color = request.getParameter("color");
            String style = request.getParameter("style");
            String material = request.getParameter("material");
            String form = request.getParameter("form");
            String lensWidth = request.getParameter("lensWidth");
            String lensHeight = request.getParameter("lensHeight");
            String bridgeWidth = request.getParameter("bridgeWidth");
            String templeLength = request.getParameter("templeLength");

            System.out.println("fileName："+ imgFile.getOriginalFilename());
            String fileName = imgFile.getOriginalFilename();
            String suffix = fileName.substring(fileName.indexOf("."));
            String projectDir = System.getProperty("catalina.home");
            String path = projectDir.replace("\\","/") + "/webapps/ROOT/jsp/css/img/商品/" + frameName + suffix;
            System.out.println(path);

            File newFile = new File(path);
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            try {
                if (!newFile.exists()) newFile.createNewFile();
                imgFile.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String framePhoto = "css/img/商品/" + frameName + suffix;
            System.out.println("AdminController: 开始添加货品 frame: " + frameName);
            adminService.addFrame(frameName,framePrice,framePhoto,userType,glassesType,color,style,material,form,lensWidth,lensHeight,bridgeWidth,templeLength);
            retcode = 0;
            msg = "上架成功";
        }

        mv.addObject("retcode",retcode);
        mv.addObject("msg",msg);
        return mv;
    }
}
