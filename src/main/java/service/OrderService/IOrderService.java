package service.OrderService;

import model.InCartGlassesBean;
import model.OrderInfoEntity;
import service.common.ICommService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by 86761 on 2017/6/10.
 */
public interface IOrderService extends ICommService {
    int generateOrder(BigDecimal totalPrice,String customerId,Integer addrId,Map<Integer,Integer> glassesIdList);
    void updateGlassesStatus(Map<Integer,Integer> glassesIdList,int orderId,String customerId);
    List<OrderInfoEntity> getOrders(String customerId);
    List<InCartGlassesBean> getGlassesItemBeans(int orderId);
    OrderInfoEntity getOrder(int orderId);
}
