package service.UserService;

import framework.exceptions.ServiceException;
import service.common.ICommService;

/**
 * Created by joy12 on 2017/5/27.
 * 功能1：注册功能，添加新用户
 * 功能2：登录功能，查找数据库，验证用户名、密码是否匹配
 * 功能3：个人中心系列——
 * 功能4：收藏
 * 功能5：取消收藏
 */
public interface IUserBasicSearvice extends ICommService {
    int collect(String userId, Integer frameId);
    int uncollect(String userId, Integer frameId);
}
