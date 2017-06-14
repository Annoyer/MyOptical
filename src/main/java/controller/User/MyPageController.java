package controller.User;

import controller.BaseController;
import model.AddressEntity;
import model.CustomerEntity;
import model.FrameEntity;
import model.PrescriptionEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.MyPageService.IMyPageService;
import service.MyPageService.Impl.MyPageServiceImpl;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 86761 on 2017/6/8.
 */
@Controller("myPageController")
public class MyPageController extends BaseController{
    @Resource
    IMyPageService myPageService=new MyPageServiceImpl();

    @RequestMapping(value = "jsp/prescription")
    public ModelAndView toPrescription(HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        CustomerEntity myInfo=(CustomerEntity) request.getSession().getAttribute("customerInfo");
        Map map=new HashMap();
        if(myInfo==null){
            System.out.println("还未登录");
            map.put("loginStatus",0);
        }
        else {
            List<PrescriptionEntity> presList = myPageService.getMyPrescription(myInfo.getCustomerId());
            mv.addObject("presList",presList);
            request.setAttribute("name", myInfo.getName());
            map.put("loginStatus",1);
        }
        mv.setViewName("prescription");
        return mv;
    }

    @RequestMapping(value = "jsp/myInfo")
    ModelAndView toMyInfo(){
        ModelAndView mv=new ModelAndView();
        CustomerEntity myInfo=(CustomerEntity) request.getSession().getAttribute("customerInfo");
        if(myInfo==null){
            System.out.println("还未登录");
            mv.addObject("loginStatus",0);
        }
        else {
            List<AddressEntity> addressEntities=myPageService.getAddressList(myInfo.getCustomerId());
            System.out.println("地址："+addressEntities.size());
            mv.addObject("addressList",addressEntities);
            mv.addObject("myInfo", myInfo);
            mv.addObject("loginStatus",1);
        }
        mv.setViewName("myInfo");
        return mv;
    }

    @RequestMapping(value="jsp/myCollection")
    ModelAndView toMyCollection(){
        ModelAndView mv=new ModelAndView();
        CustomerEntity myInfo=(CustomerEntity) request.getSession().getAttribute("customerInfo");
        if(myInfo==null){
            System.out.println("还未登录");
            mv.addObject("loginStatus",0);
        }
        else {
            request.setAttribute("name", myInfo.getName());
            System.out.println("myId:" + myInfo.getCustomerId());
            List<FrameEntity> frameEntityList = myPageService.getCollectList(myInfo.getCustomerId());
            mv.addObject("list", frameEntityList);
            mv.addObject("loginStatus",1);
        }
        mv.setViewName("myCollection");
        return mv;
    }

}
