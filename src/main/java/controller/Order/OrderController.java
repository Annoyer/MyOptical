package controller.Order;

import model.CustomerEntity;
import model.InCartGlassesBean;
import model.OrderInfoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.OrderService.IOrderService;
import service.OrderService.OrderServiceImpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 86761 on 2017/6/10.
 */
@Controller("OrderController")
public class OrderController {
    @Resource
    IOrderService orderService=new OrderServiceImpl();

    @RequestMapping(value = "jsp/balance")
    public Map generateOrder(HttpServletRequest request){
        Map result=new HashMap();
        String[] idList=request.getParameterValues("ids[]");
        String[] countList=request.getParameterValues("counts[]");
        BigDecimal totalPrice=new BigDecimal(request.getParameter("totalPrice"));
        Map map=new HashMap();
        for(int i=0;i<idList.length;i++){
            System.out.println("i="+i);
            map.put(Integer.valueOf(idList[i]),Integer.valueOf(countList[i]));
        }
        CustomerEntity customerEntity=(CustomerEntity) request.getSession().getAttribute("customerInfo");
        orderService.generateOrder(totalPrice,customerEntity.getCustomerId(),1,map);

        result.put("returnCode",1);
        return result;
    }

    @RequestMapping(value = "jsp/myOrder")
    public ModelAndView toMyOrder(HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        CustomerEntity myInfo=(CustomerEntity) request.getSession().getAttribute("customerInfo");
        mv.addObject("myName",myInfo.getName());
        System.out.println("myId:" +myInfo.getCustomerId());
        int orderId=Integer.valueOf(request.getParameter("orderId"));
        List<InCartGlassesBean> beans=orderService.getGlassesItemBeans(orderId);
        mv.addObject("glassesList",beans);
        mv.setViewName("myOrder");
        return mv;
    }
}
