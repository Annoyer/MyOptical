package service.UserService.Impl;

import framework.exceptions.ServiceException;
import model.CollectsEntity;
import model.CustomerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import service.UserService.IUserBasicSearvice;
import service.common.impl.CommServiceImpl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

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
    public int collect(String userId, String frameId) {
        int retcode = 0;
        CollectsEntity collectsEntity = new CollectsEntity();
        collectsEntity.setId(userId);
        collectsEntity.setFrameId(frameId);
        baseDAO.save(collectsEntity);
        return retcode;
    }

    @Override
    public int uncollect(String userId, String frameId) {
        int retcode = 0;
        CollectsEntity collectsEntity = new CollectsEntity();
        collectsEntity.setId(userId);
        collectsEntity.setFrameId(frameId);
        if(baseDAO.findByExample(collectsEntity,CollectsEntity.class).isEmpty()){
            retcode = 1;
        }else{
            baseDAO.delete(collectsEntity);
        }
        return retcode;
    }
}
