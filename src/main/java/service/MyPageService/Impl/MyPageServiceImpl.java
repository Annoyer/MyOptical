package service.MyPageService.Impl;

import model.FrameEntity;
import model.PrescriptionEntity;
import org.springframework.stereotype.Service;
import service.MyPageService.IMyPageService;
import service.common.impl.CommServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 86761 on 2017/6/9.
 */
@Service("IMyPageService")
public class MyPageServiceImpl extends CommServiceImpl implements IMyPageService {
    @Override
    public List<FrameEntity> getCollectList(String customerId) {
        if (baseDAO == null) {
            System.out.println("...");
        }

        List<Integer> frameIdList = baseDAO.getCollectionByCustomerId(customerId);
        System.out.println("list:"+frameIdList.size());
        System.out.println("frameIdListGet!");
        List<FrameEntity> frameEntityList = new ArrayList<FrameEntity>();
        for (Integer frameId : frameIdList) {
            FrameEntity frameEntity = baseDAO.findById(frameId, FrameEntity.class);
            frameEntityList.add(frameEntity);
        }

        return frameEntityList;
    }
    public List<PrescriptionEntity> getMyPrescription(String customerId){
        List<PrescriptionEntity> prescriptionEntities=baseDAO.findByProperty("customerId",customerId,PrescriptionEntity.class);
        return prescriptionEntities;
    }
}
