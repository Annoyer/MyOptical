package controller.User;

import controller.BaseController;
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
        CustomerEntity customerEntity=(CustomerEntity) request.getSession().getAttribute("customerInfo");
        Map map=new HashMap();
        if(customerEntity==null){
            System.out.println("还未登录");
            map.put("loginStatus",0);
        }
        else {
            List<PrescriptionEntity> presList = myPageService.getMyPrescription(customerEntity.getCustomerId());
            mv.addObject("presList",presList);
            map.put("loginStatus",1);
        }
        mv.setViewName("prescription");
        return mv;
    }

    @RequestMapping(value = "jsp/myInfo")
    ModelAndView toMyInfo(){
        ModelAndView mv=new ModelAndView();
        CustomerEntity myInfo=(CustomerEntity) request.getSession().getAttribute("customerInfo");
        Map map=new HashMap();
        map.put("myInfo",myInfo);
        mv.addObject(map);
        mv.setViewName("myInfo");
        return mv;
    }

    @RequestMapping(value="jsp/myCollection")
    ModelAndView toMyCollection(){
        ModelAndView mv=new ModelAndView();
        CustomerEntity myInfo=(CustomerEntity) request.getSession().getAttribute("customerInfo");
        mv.addObject("myName",myInfo.getName());
        System.out.println("myId:" +myInfo.getCustomerId());
        List<FrameEntity> frameEntityList=myPageService.getCollectList(myInfo.getCustomerId());
        mv.addObject("list",frameEntityList);
        mv.setViewName("myCollection");
        return mv;
    }
}
