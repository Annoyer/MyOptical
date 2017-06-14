package service.MyPageService;

import model.AddressEntity;
import model.FrameEntity;
import model.PrescriptionEntity;
import service.common.ICommService;

import java.util.List;

/**
 * Created by 86761 on 2017/6/9.
 * 1.展示收藏列表
 * 2.展示处方列表
 * 3.展示订单列表
 */
public interface IMyPageService extends ICommService{
    List<FrameEntity> getCollectList(String customerId);
    List<PrescriptionEntity> getMyPrescription(String customerId);
    List<AddressEntity> getAddressList(String customerId);
}
