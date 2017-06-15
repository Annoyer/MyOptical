package service.OrderService;

import model.*;
import oracle.sql.TIMESTAMP;
import org.springframework.stereotype.Service;
import service.common.impl.CommServiceImpl;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 86761 on 2017/6/10.
 * 1.创建订单
 * 2.修改订单中glassesList的状态，inCart改为inOrder
 * 3.展示订单
 */
@Service("IOrderService")
public class OrderServiceImpl extends CommServiceImpl implements IOrderService {
    public int generateOrder(BigDecimal totalPrice,String customerId,Integer addrId,Map<Integer,Integer> glassesIdList){
        OrderInfoEntity orderInfoEntity=new OrderInfoEntity();
        orderInfoEntity.setCustomerId(customerId);
        orderInfoEntity.setAddrId(addrId);
        orderInfoEntity.setTotalPrice(totalPrice);
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        orderInfoEntity.setOrderTime(timestamp);
        baseDAO.save(orderInfoEntity);
        updateGlassesStatus(glassesIdList,orderInfoEntity.getOrderId(),customerId);
        return orderInfoEntity.getOrderId();
    }

    public void updateGlassesStatus(Map<Integer,Integer> glassesIdList, int orderId,String customerId){
        for(Integer glassesId:glassesIdList.keySet()){
            InCartEntity inCartEntity=new InCartEntity();
            inCartEntity.setGlassesItemId(glassesId);
            inCartEntity.setCustomerId(customerId);
            baseDAO.delete(inCartEntity);
            InOrderEntity inOrderEntity=new InOrderEntity();
            inOrderEntity.setGlassesItemId(glassesId);
            inOrderEntity.setOrderId(orderId);
            inOrderEntity.setItemCount(glassesIdList.get(glassesId));
            baseDAO.save(inOrderEntity);
        }
    }

    @Override
    public List<OrderInfoEntity> getOrders(String customerId){
        List<OrderInfoEntity> orderInfoEntities=baseDAO.findByProperty("customerId",customerId,OrderInfoEntity.class);
        return orderInfoEntities;
    }

    @Override
    public List<InCartGlassesBean> getGlassesItemBeans(int orderId){
        List<InOrderEntity> inOrderEntities=baseDAO.findByProperty("orderId",orderId,InOrderEntity.class);
        System.out.println("inOrder "+orderId+":"+inOrderEntities.size());
        List<InCartGlassesBean> beans=new ArrayList<InCartGlassesBean>();

        for(InOrderEntity inOrder:inOrderEntities){
            System.out.println(inOrder.toString());
            InCartGlassesBean bean=new InCartGlassesBean();

            GlassesItemEntity glassesItemEntity=baseDAO.findById(inOrder.getGlassesItemId(),GlassesItemEntity.class);
            bean.setGlassesItemId(inOrder.getGlassesItemId());
            bean.setGlassesPrice(glassesItemEntity.getGlassesPrice());

            FrameEntity frameEntity=baseDAO.findById(glassesItemEntity.getFrameId(),FrameEntity.class);
            bean.setFrameId(frameEntity.getFrameId());
            bean.setFrameName(frameEntity.getFrameName());
            bean.setFramePhoto(frameEntity.getFramePhoto());

            PrescriptionEntity prescriptionEntity=baseDAO.findById(glassesItemEntity.getPresId(),PrescriptionEntity.class);
            bean.setlAxis(prescriptionEntity.getlAxis());
            bean.setlCyl(prescriptionEntity.getlCyl());
            bean.setlSph(prescriptionEntity.getlSph());
            bean.setrSph(prescriptionEntity.getrSph());
            bean.setrAxis(prescriptionEntity.getrAxis());
            bean.setrCyl(prescriptionEntity.getrCyl());
            bean.setPd(prescriptionEntity.getPd());

            beans.add(bean);
        }
        return beans;
    }

    public OrderInfoEntity getOrder(int orderId){
        return baseDAO.findById(orderId,OrderInfoEntity.class);
    }

    @Override
    public FrameEntity getFrameByFrameId(Integer frameId) {
        FrameEntity frameInfo = baseDAO.findById(frameId,FrameEntity.class);
        return frameInfo;
    }

    @Override
    public void postComment(String comment,String customerId,int frameId){
        CommentEntity commentEntity=new CommentEntity();
        commentEntity.setCustomerId(customerId);
        commentEntity.setCommText(comment);
        commentEntity.setFrameId(frameId);
        commentEntity.setCommTime(new Timestamp(new Date().getTime()));
        baseDAO.save(commentEntity);
        System.out.println("评论保存成功");
    }
}
