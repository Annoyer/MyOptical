package controller.Order;

import controller.BaseController;
import model.CustomerEntity;
import model.FrameEntity;
import model.GlassesItemEntity;
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
 * 2.展现购物车页面
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
        }
        else {
            List<GlassesItemEntity> glassesItemEntityList = cartService.getGlassesItemList(customerEntity.getCustomerId());
            mv.addObject("glassesList",glassesItemEntityList);
        }
        mv.setViewName("cart");
        return mv;
    }

    @RequestMapping(value = "jsp/cart/getNameByFrameId",method = RequestMethod.POST)
    public Map getNameByFrameId(HttpServletRequest request){
        String frameId=request.getParameter("thisframeId");
        System.out.println("frameId   "+frameId);
        FrameEntity frameEntity=cartService.getFrameEntity(Integer.valueOf(frameId));
        Map result=new HashMap();
        result.put("frameName",frameEntity.getFrameName());
        return result;
    }

    @RequestMapping(value="jsp/glassesItemSetting")
    public ModelAndView toGlassesItemSettingPage(HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        int frameId=Integer.parseInt(request.getParameter("frameId"));
        FrameEntity frameEntity=cartService.getFrameEntity(frameId);
        mv.setViewName("glassesItemSetting");
        mv.addObject("frame",frameEntity);
        return mv;
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

        BigDecimal glassesPrice=new BigDecimal(request.getParameter("glassesPrice"));
        System.out.println(glassesPrice.toString());
        BigDecimal rSph=new BigDecimal(request.getParameter("rSph"));
        BigDecimal lSph=new BigDecimal(request.getParameter("lSph"));
        BigDecimal rCyl=new BigDecimal(request.getParameter("rCyl"));
        BigDecimal lCyl=new BigDecimal(request.getParameter("lCyl"));
        Integer rAxis=new Integer(request.getParameter("rAxis"));
        Integer lAxis=new Integer(request.getParameter("lAxis"));
        Integer pd=new Integer(request.getParameter("pd"));
        System.out.println(rSph.toString()+' '+lSph.toString());

        CustomerEntity customerEntity = (CustomerEntity) request.getSession().getAttribute("customerInfo");
        String customerId=customerEntity.getCustomerId();
        System.out.println(customerId);
        cartService.addGlassesItem(frameId,customerId,lensColor,material,glassesPrice,
                rSph,lSph,rCyl,lCyl, rAxis, lAxis,pd);
        result.put("returnCode",1);
        return result;
    }
}
