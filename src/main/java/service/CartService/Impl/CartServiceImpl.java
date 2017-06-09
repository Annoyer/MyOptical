package service.CartService.Impl;

import model.FrameEntity;
import model.GlassesItemEntity;
import model.InCartEntity;
import model.PrescriptionEntity;
import org.springframework.stereotype.Service;
import service.CartService.ICartService;
import service.common.impl.CommServiceImpl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 86761 on 2017/6/6.
 * 1.添加glasses_item（in_cart,in_pre,glasses_frame,addition）
 * 2.删除glasses_item(in_cart,in_pre,glasses_frame,addition)
 * 3.在购物车中展示用户的glasses item list
 * 4.保存prescription到数据库中，customerId设为用户Id（点击保存设置）
 */
@Service("ICartService")
public class CartServiceImpl extends CommServiceImpl implements ICartService {
    @Override
    public void addGlassesItem(int frameId,String customerId,
                               String lensColor,String material,BigDecimal glassesPrice,
                               BigDecimal rSph, BigDecimal lSph, BigDecimal rCyl, BigDecimal lCyl,
                               Integer rAxis, Integer lAxis, Integer pd){
        System.out.println("addGlassesItem");
        PrescriptionEntity prescriptionEntity=setPrescription( rSph,lSph,rCyl,lCyl, rAxis, lAxis,pd,null,null);

        int presId=prescriptionEntity.getPresId();
        GlassesItemEntity glassesItemEntity=new GlassesItemEntity();
        glassesItemEntity.setLensColor(lensColor);
        glassesItemEntity.setLensMaterial(material);
        glassesItemEntity.setGlassesPrice(glassesPrice);
        glassesItemEntity.setFrameId(frameId);
        glassesItemEntity.setPresId(presId);

        baseDAO.save(glassesItemEntity);

        int glassesItemId=glassesItemEntity.getGlassesItemId();
        InCartEntity inCartEntity=new InCartEntity();
        inCartEntity.setCustomerId(customerId);
        inCartEntity.setGlassesItemId(glassesItemId);
        baseDAO.save(inCartEntity);
    }

    @Override
    public void removeGlassesItem(int glassesItemId){
        GlassesItemEntity glassesItemEntity=baseDAO.findById(glassesItemId, GlassesItemEntity.class);
        baseDAO.delete(glassesItemEntity);
    }

    @Override
    public List<GlassesItemEntity> getGlassesItemList(String customerId){
        List<Integer> glassesIdList=baseDAO.getCartItemByCustomerId(customerId);
        System.out.println(glassesIdList.toString());
        List<GlassesItemEntity> glassesItemEntities=new ArrayList<GlassesItemEntity>();

        for(Integer glassesId:glassesIdList){
            System.out.println(glassesId);
            GlassesItemEntity glassesItemEntity=baseDAO.findById(glassesId,GlassesItemEntity.class);
            glassesItemEntities.add(glassesItemEntity);
        }
        return glassesItemEntities;
    }

    @Override
    public PrescriptionEntity setPrescription(BigDecimal rSph, BigDecimal lSph, BigDecimal rCyl, BigDecimal lCyl,
                                              Integer rAxis, Integer lAxis, Integer pd,String presName,String customerId){
        System.out.println("setPrescription");
        PrescriptionEntity prescriptionEntity=new PrescriptionEntity();
        if(presName!=null) {
            prescriptionEntity.setPresName(presName);
        }
        prescriptionEntity.setrSph(rSph);
        prescriptionEntity.setrCyl(rCyl);
        prescriptionEntity.setrAxis(rAxis);
        prescriptionEntity.setPd(pd);
        prescriptionEntity.setlSph(lSph);
        prescriptionEntity.setlCyl(lCyl);
        prescriptionEntity.setlAxis(lAxis);
        if(customerId!=null){
            prescriptionEntity.setCustomerId(customerId);
        }
        baseDAO.save(prescriptionEntity);
        return prescriptionEntity;
    }

    @Override
    public FrameEntity getFrameEntity(int frameId){
        return baseDAO.findById(frameId, FrameEntity.class);
    }

    @Override
    public List<FrameEntity> getGlassesFrameList(List<GlassesItemEntity> glassesItemEntities){
        List<FrameEntity> frameEntityList=new ArrayList<FrameEntity>();
        for(GlassesItemEntity glassesItemEntity:glassesItemEntities){
            frameEntityList.add(getFrameEntity(glassesItemEntity.getFrameId()));
        }
        return frameEntityList;
    }
}
