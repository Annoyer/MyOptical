package service.OrderService.Impl;

import org.springframework.stereotype.Service;
import service.OrderService.IOrderSearvice;
import service.common.impl.CommServiceImpl;

/**
 * Created by joy12 on 2017/5/27.
 * 功能1：创建新订单
 * 功能2：查看过去订单
 * 功能3：取消（删除）订单
 */
@Service("IOrderService")
public class OrderServiceImpl extends CommServiceImpl implements IOrderSearvice {
}
