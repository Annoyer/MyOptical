package controller.User;

import controller.BaseController;
import cst.Constants;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService.IUserBasicSearvice;
import service.UserService.Impl.UserBasicServiceImpl;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

/**
 * Created by joy12 on 2017/5/27.
 * 功能1：登录
 * 功能2：注册
 * 功能3：个人基本信息修改
 * 功能4【完成】：收藏
 * 功能5【完成】：取消收藏
 */
@Controller("userBasicController")
public class UserBasicController extends BaseController {
    @Autowired
    private HttpServletRequest request;

    private IUserBasicSearvice userBasicSearvice = new UserBasicServiceImpl();

    @RequestMapping(value = "/jsp/user/collect")
    public Map collectFrame(){
        Map result = new HashMap();
        //做登录注册的时候，登录以后要将本人的用户id存进session里
        //以及还需要做登录验证
        String userId = request.getSession().getAttribute("userId").toString();
        String frameId = request.getParameter("frameId");
        System.out.println("UserBasicController: 开始收藏 user: " + userId + "  frame: " + frameId);
        int retcode = userBasicSearvice.collect(userId,frameId);

        result.put("retcode",retcode);
        return result;
    }

    @RequestMapping(value = "/jsp/user/uncollect")
    public Map uncollectFrame(){
        Map result = new HashMap();
        //做登录注册的时候，登录以后要将本人的用户id存进session里
        //以及还需要做登录验证
        String userId = request.getSession().getAttribute("userId").toString();
        String frameId = request.getParameter("frameId");
        System.out.println("UserBasicController: 开始取消收藏 user: " + userId + "  frame: " + frameId);
        int retcode = userBasicSearvice.uncollect(userId,frameId);

        result.put("retcode",retcode);
        return result;
    }
}
