package service.CartService;

import model.FrameEntity;
import model.GlassesItemEntity;
import model.InCartGlassesBean;
import model.PrescriptionEntity;
import service.common.ICommService;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 86761 on 2017/6/6.
 * 1.添加glasses_item到购物车
 * 2.从购物车删除glasses_item
 * 3.展示用户在购物车中的glasses item list
 * 4.保存prescription到数据库中，customerId设为用户Id（点击保存设置）
 */

public interface ICartService extends ICommService {
    void addGlassesItem(int frameId, String customerId,
                        String lensColor, String material, BigDecimal glassesPrice,
                        BigDecimal rSph, BigDecimal lSph, BigDecimal rCyl, BigDecimal lCyl,
                        Integer rAxis, Integer lAxis, Integer pd,
                        String leftText, String rightText,String presName);
    void removeGlassesItem(int glassesItemId);
    List<GlassesItemEntity> getGlassesItemList(String customerId);
    PrescriptionEntity setPrescription(BigDecimal rSph, BigDecimal lSph, BigDecimal rCyl, BigDecimal lCyl,
                                       Integer rAxis, Integer lAxis, Integer pd,String presName,String customerId);
    FrameEntity getFrameEntity(int frameId);
    List<FrameEntity> getGlassesFrameList(List<GlassesItemEntity> glassesItemEntities);
    List<InCartGlassesBean> getGlassesItemBeans(String customerId);
}
