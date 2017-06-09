package service.CartService;

import model.FrameEntity;
import model.GlassesItemEntity;
import model.PrescriptionEntity;
import service.common.ICommService;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 86761 on 2017/6/6.
 * 1.添加glasses_item（in_cart,in_pre,glasses_frame,addition）
 * 2.删除glasses_item(in_cart,in_pre,glasses_frame,addition)
 * 3.在购物车中展示用户的glasses item list
 * 4.保存prescription到数据库中，customerId设为用户Id（点击保存设置）
 */

public interface ICartService extends ICommService {
    void addGlassesItem(int frameId, String customerId,
                        String lensColor, String material, BigDecimal glassesPrice,
                        BigDecimal rSph, BigDecimal lSph, BigDecimal rCyl, BigDecimal lCyl,
                        Integer rAxis, Integer lAxis, Integer pd);
    void removeGlassesItem(int glassesItemId);
    List<GlassesItemEntity> getGlassesItemList(String customerId);
    PrescriptionEntity setPrescription(BigDecimal rSph, BigDecimal lSph, BigDecimal rCyl, BigDecimal lCyl,
                                       Integer rAxis, Integer lAxis, Integer pd,String presName,String customerId);
    FrameEntity getFrameEntity(int frameId);
    List<FrameEntity> getGlassesFrameList(List<GlassesItemEntity> glassesItemEntities);
}
