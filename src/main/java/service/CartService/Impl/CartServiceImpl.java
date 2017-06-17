package service.CartService.Impl;

import model.*;
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
                               Integer rAxis, Integer lAxis, Integer pd,
                               String leftText, String rightText,String presName){
        System.out.println("addGlassesItem");
        PrescriptionEntity prescriptionEntity=setPrescription( rSph,lSph,rCyl,lCyl, rAxis, lAxis,pd,presName,customerId);

        int presId=prescriptionEntity.getPresId();
        GlassesItemEntity glassesItemEntity=new GlassesItemEntity();
        glassesItemEntity.setLensColor(lensColor);
        glassesItemEntity.setLensMaterial(material);
        glassesItemEntity.setGlassesPrice(glassesPrice);
        glassesItemEntity.setFrameId(frameId);
        glassesItemEntity.setPresId(presId);
        glassesItemEntity.setLeftText(leftText);
        glassesItemEntity.setRightText(rightText);

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
        if(presName!="") {
            prescriptionEntity.setPresName(presName);
        }
        else prescriptionEntity.setPresName(null);
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

    @Override
    public List<InCartGlassesBean> getGlassesItemBeans(String customerId){
        List<Integer> glassesIdList=baseDAO.getCartItemByCustomerId(customerId);
        System.out.println(glassesIdList.toString());
        List<InCartGlassesBean> beans=new ArrayList<InCartGlassesBean>();

        for(Integer glassesId:glassesIdList){
            System.out.println(glassesId);
            InCartGlassesBean bean=new InCartGlassesBean();

            GlassesItemEntity glassesItemEntity=baseDAO.findById(glassesId,GlassesItemEntity.class);
            bean.setGlassesItemId(glassesId);
            bean.setGlassesPrice(glassesItemEntity.getGlassesPrice());
            bean.setLeftText(glassesItemEntity.getLeftText());
            bean.setRightText(glassesItemEntity.getRightText());

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
@Override
    public List<PrescriptionEntity> getMyPrescription(String customerId){
        List<PrescriptionEntity> prescriptionEntities=baseDAO.findByProperty("customerId",customerId,PrescriptionEntity.class);
        List<PrescriptionEntity> myPres=new ArrayList<PrescriptionEntity>();
        for(PrescriptionEntity prescriptionEntity:prescriptionEntities){
            if(prescriptionEntity.getPresName()!=null){
                myPres.add(prescriptionEntity);
            }
        }
        return myPres;
    }
}
