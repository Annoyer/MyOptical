package service.UserService;

import framework.exceptions.ServiceException;
import model.FrameEntity;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import service.common.ICommService;

import java.util.List;
import java.util.Map;

/**
 * Created by joy12 on 2017/5/27.
 * 功能1：注册功能，添加新用户
 * 功能2：登录功能，查找数据库，验证用户名、密码是否匹配
 * 功能3：个人中心系列——
 * 功能4：收藏
 * 功能5：取消收藏
 */
public interface IUserBasicSearvice extends ICommService {
    int register(String id, String password, String nickName, String phone,String email);
    Map login(String id, String password);
    int collect(String customerId, Integer frameId);
    int uncollect(String customerId, Integer frameId);
}
