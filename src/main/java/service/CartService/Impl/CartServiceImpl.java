package service.CartService.Impl;

import model.FrameEntity;
import model.GlassesItemEntity;
import model.InCartEntity;
import model.PrescriptionEntity;
import org.springframework.stereotype.Service;
import service.CartService.ICartService;
import service.common.impl.CommServiceImpl;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 86761 on 2017/6/6.
 */
@Service("ICartService")
public class CartServiceImpl extends CommServiceImpl implements ICartService {
    @Override
    public void addGlassesItem(int frameId,String customerId,
                               String lensColor,String material,BigDecimal glassesPrice,
                               BigDecimal rSph, BigDecimal lSph, BigDecimal rCyl, BigDecimal lCyl,
                               Integer rAxis, Integer lAxis, Integer pd){
        System.out.println("addGlassesItem");
        PrescriptionEntity prescriptionEntity=setPrescription( rSph,lSph,rCyl,lCyl, rAxis, lAxis,pd);

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

    }

    @Override
    public void removeGlassesItem(int glassesItemId){
        GlassesItemEntity glassesItemEntity=baseDAO.findById(glassesItemId, GlassesItemEntity.class);
        baseDAO.delete(glassesItemEntity);
    }

    @Override
    public List<GlassesItemEntity> getGlassesItemList(String customerId){
        List<GlassesItemEntity> glassesItemEntities=baseDAO.findByProperty("customer_id",customerId, GlassesItemEntity.class);
        return glassesItemEntities;
    }

    @Override
    public PrescriptionEntity setPrescription(BigDecimal rSph, BigDecimal lSph, BigDecimal rCyl, BigDecimal lCyl,
                                              Integer rAxis, Integer lAxis, Integer pd){
        System.out.println("setPrescription");
        PrescriptionEntity prescriptionEntity=new PrescriptionEntity();
        prescriptionEntity.setrSph(rSph);
        prescriptionEntity.setrCyl(rCyl);
        prescriptionEntity.setrAxis(rAxis);
        prescriptionEntity.setPd(pd);
        prescriptionEntity.setlSph(lSph);
        prescriptionEntity.setlCyl(lCyl);
        prescriptionEntity.setlAxis(lAxis);
        baseDAO.save(prescriptionEntity);
        return prescriptionEntity;
    }

    @Override
    public FrameEntity getFrameEntity(int frameId){
        return baseDAO.findById(frameId, FrameEntity.class);
    }
}
