package service.UserService.Impl;

import framework.exceptions.ServiceException;
import model.CollectsEntity;
import model.CustomerEntity;
import model.FrameEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import service.UserService.IUserBasicSearvice;
import service.common.impl.CommServiceImpl;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by joy12 on 2017/5/27.
 * 功能1：注册功能，添加新用户
 * 功能2：登录功能，查找数据库，验证用户名、密码是否匹配
 * 功能3：个人中心系列——
 * 功能4：收藏
 * 功能5：取消收藏
 */
@Service("IUserBasicService")
public class UserBasicServiceImpl extends CommServiceImpl implements IUserBasicSearvice {

    @Override
    //1-已注册过 0-成功
    public int register(String id, String password, String nickName,String phone, String email) {
        int retcode = 0;
        //检查用户名是否注册过
        if(baseDAO.findById(id,CustomerEntity.class) == null){
            CustomerEntity newCustomer = new CustomerEntity();
            newCustomer.setCustomerId(id);
            newCustomer.setPassword(password);
            newCustomer.setName(nickName);
            newCustomer.setPhone(phone);
            newCustomer.setEmail(email);
            baseDAO.save(newCustomer);
        }else {
            retcode = 1;
        }
        return retcode;
    }


    @Override
    //2-用户不存在 1-密码错误 0-成功
    public Map login(String id, String password) {
        Map result = new HashMap();
        int retcode = 0;
        CustomerEntity customerInfo = baseDAO.findById(id,CustomerEntity.class);

        if (customerInfo == null){
            retcode = 2;
        }else if (!customerInfo.getPassword().contentEquals(password)){
            retcode = 1;
        }else {
            result.put("customerInfo",customerInfo);
        }
        result.put("retcode",retcode);
        return result;
    }

    @Override
    public int collect(String customerId, Integer frameId) {
        int retcode = 0;
        CollectsEntity collectsEntity = new CollectsEntity();
        collectsEntity.setCustomerId(customerId);
        collectsEntity.setFrameId(frameId);
        if(!baseDAO.findByExample(collectsEntity,CollectsEntity.class).isEmpty()){
            retcode = 1;
        }else {
            baseDAO.save(collectsEntity);
        }
        return retcode;
    }

    @Override
    public int uncollect(String customerId, Integer frameId) {
        int retcode = 0;
        String hql = "from CollectsEntity as model where model.frameId=? and model.customerId=?";
        CollectsEntity collectsEntity = (CollectsEntity) baseDAO.findByHQL(hql,new Object[]{frameId,customerId}).get(0);
        if(collectsEntity == null){
            retcode = 1;
        }else{
            baseDAO.delete(collectsEntity);
        }
        return retcode;
    }


}
