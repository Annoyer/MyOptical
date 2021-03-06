package controller.Order;

import controller.BaseController;
import model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.CartService.ICartService;
import service.CartService.Impl.CartServiceImpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 86761 on 2017/6/6.
 * 1.将单个眼镜设置添加到购物车，保存到数据库
 * 2.将处方设置保存在我的处方中
 * 3.展现购物车页面
 */
@Controller("CartController")
public class CartController extends BaseController {
    @Resource
    private ICartService cartService= new CartServiceImpl();

    @RequestMapping(value = "jsp/cart")
    public ModelAndView toCart(HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        CustomerEntity customerEntity=(CustomerEntity)request.getSession().getAttribute("customerInfo");
        if(customerEntity==null){
            mv.addObject("returnCode",0);//未登录
            System.out.println("还未登录");
        }
        else {
            List<InCartGlassesBean> getGlassesItemBeans=cartService.getGlassesItemBeans(customerEntity.getCustomerId());
       //     List<GlassesItemEntity> glassesItemEntityList = cartService.getGlassesItemList(customerEntity.getCustomerId());
         //   mv.addObject("glassesList",glassesItemEntityList);
            mv.addObject("glassesList",getGlassesItemBeans);
            mv.addObject("returnCode",1);
        }
        mv.setViewName("cart");
        return mv;
    }

    @RequestMapping(value="jsp/cart/delete")
    @ResponseBody
    public Map deleteFromCart(HttpServletRequest request){
        Map result=new HashMap();
        System.out.println("deleteFromCart");
        String glassesid=request.getParameter("glassesItemId");
        System.out.println(glassesid);
        int glassesItemId=Integer.valueOf(glassesid);
        cartService.removeGlassesItem(glassesItemId);
        result.put("returnCode",1);
        System.out.println("删除成功！");
        return result;
    }



    @RequestMapping(value="jsp/glassesItemSetting")
    public ModelAndView toGlassesItemSettingPage(HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        CustomerEntity myInfo=(CustomerEntity) request.getSession().getAttribute("customerInfo");
        int frameId=Integer.parseInt(request.getParameter("frameId"));
        FrameEntity frameEntity=cartService.getFrameEntity(frameId);
        if(myInfo!=null){
        List<PrescriptionEntity> prescriptionEntities=cartService.getMyPrescription(myInfo.getCustomerId());
        mv.addObject("list",prescriptionEntities);
        }
        mv.setViewName("glassesItemSetting");
        mv.addObject("frame",frameEntity);
        return mv;
    }

    @RequestMapping(value = "jsp/get/prescription")
    @ResponseBody
    public Map getPres(HttpServletRequest request) {
        Map result=new HashMap();
        CustomerEntity myInfo = (CustomerEntity) request.getSession().getAttribute("customerInfo");
        int presIndex = Integer.parseInt(request.getParameter("presIndex"));
        if (myInfo != null){
            List<PrescriptionEntity> list = cartService.getMyPrescription(myInfo.getCustomerId());
            PrescriptionEntity prescriptionEntity=list.get(presIndex);
            result.put("lSph",prescriptionEntity.getlSph());
            result.put("lCyl",prescriptionEntity.getlCyl());
            result.put("lAxis",prescriptionEntity.getlAxis());
            result.put("rSph",prescriptionEntity.getrSph());
            result.put("rCyl",prescriptionEntity.getrCyl());
            result.put("rAxis",prescriptionEntity.getrAxis());
            result.put("pd",prescriptionEntity.getPd());
            result.put("returnCode",1);
        }
        return result;
    }

    @RequestMapping(value = "jsp/glassesItem/Setting",method = RequestMethod.POST)
    @ResponseBody
    public Map getSetting(HttpServletRequest request){
        System.out.println("getSetting");
        Map result=new HashMap();
        int frameId=Integer.parseInt(request.getParameter("frameId"));
        System.out.println(frameId);
        String lensColor=request.getParameter("lensColor");
        System.out.println(lensColor);
        String material=request.getParameter("lensMaterial");
        System.out.println(material);
        //String lensType=request.getParameter("lensType");
        String price=request.getParameter("glassesPrice");
        System.out.println(price.toString());
        BigDecimal glassesPrice=new BigDecimal(request.getParameter("glassesPrice"));
        BigDecimal rSph=new BigDecimal(request.getParameter("rSph"));
        BigDecimal lSph=new BigDecimal(request.getParameter("lSph"));
        BigDecimal rCyl=new BigDecimal(request.getParameter("rCyl"));
        BigDecimal lCyl=new BigDecimal(request.getParameter("lCyl"));
        Integer rAxis=new Integer(request.getParameter("rAxis"));
        Integer lAxis=new Integer(request.getParameter("lAxis"));
        Integer pd=new Integer(request.getParameter("pd"));
        String leftText=request.getParameter("leftText");
        String rightText=request.getParameter("rightText");
        String presName=request.getParameter("presName");

        System.out.println(rSph.toString()+' '+lSph.toString());

        CustomerEntity customerEntity = (CustomerEntity) request.getSession().getAttribute("customerInfo");
        if(customerEntity==null){
            result.put("returnCode",0);
            System.out.println("还未登录");
        }
        else {
            String customerId = customerEntity.getCustomerId();
            System.out.println(customerId);
            cartService.addGlassesItem(frameId, customerId, lensColor, material, glassesPrice,
                    rSph, lSph, rCyl, lCyl, rAxis, lAxis, pd,leftText,rightText,presName);
            result.put("returnCode", 1);
        }
        return result;
    }

//    @RequestMapping(value = "jsp/save/prescription",method = RequestMethod.POST)
//    @ResponseBody
//    public Map savePrescription(){
//        Map map=new HashMap();
//        String presName=request.getParameter("presName");
//        BigDecimal rSph=new BigDecimal(request.getParameter("rSph"));
//        BigDecimal lSph=new BigDecimal(request.getParameter("lSph"));
//        BigDecimal rCyl=new BigDecimal(request.getParameter("rCyl"));
//        BigDecimal lCyl=new BigDecimal(request.getParameter("lCyl"));
//        Integer rAxis=new Integer(request.getParameter("rAxis"));
//        Integer lAxis=new Integer(request.getParameter("lAxis"));
//        Integer pd=new Integer(request.getParameter("pd"));
//        CustomerEntity customerEntity = (CustomerEntity) request.getSession().getAttribute("customerInfo");
//        if(customerEntity==null){
//            map.put("returnCode",0);
//        }
//        else {
//            cartService.setPrescription(rSph, lSph, rCyl, lCyl, rAxis, lAxis, pd,presName, customerEntity.getCustomerId());
//            map.put("returnCode", 1);
//        }
//        return map;
//    }
}
