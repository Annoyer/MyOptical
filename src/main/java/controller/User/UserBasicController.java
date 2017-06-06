package controller.User;

import controller.BaseController;
import cst.Constants;
import model.CustomerEntity;
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
    @Resource
    private IUserBasicSearvice userBasicSearvice = new UserBasicServiceImpl();

    @RequestMapping(value = "/jsp/register", method = RequestMethod.POST)
    @ResponseBody
    public Map register(HttpServletRequest request){
        Map result = new HashMap();
        String msg = "注册成功";
        String registerAccount = request.getParameter("register_account");
        String registerPassword = request.getParameter("register_password");
        String registerNickname = request.getParameter("register_nickname");
        String registerPhone = request.getParameter("register_phone");
        String registerEmail = request.getParameter("register_email");

        System.out.println("UserBasicController: 开始注册");
        System.out.println("registerAccount: " + registerAccount);
        System.out.println("registerPassword: " + registerPassword);
        System.out.println("registerNickname: " + registerNickname);
        System.out.println("registerPhone: " + registerPhone);
        System.out.println("registerEmail: " + registerEmail);

        int retcode = userBasicSearvice.register(registerAccount,registerPassword,registerNickname,registerPhone,registerEmail);
        if (retcode == 1){
            msg = "用户名已存在";
        }
        System.out.println("retcode: " + retcode + "   msg: " + msg);
        result.put("retcode",retcode);
        result.put("msg",msg);
        return result;
    }

    @RequestMapping(value = "/jsp/login",method = RequestMethod.POST)
    @ResponseBody
    public Map login(HttpServletRequest request){
        Map result = new HashMap();
        String msg = "系统正忙，请稍后再试";
        String loginAccount = request.getParameter("login_account");
        String loginPassword = request.getParameter("login_password");

        System.out.println("UserBasicController: 开始登录");
        System.out.println("loginAccount: " + loginAccount);
        System.out.println("loginPassword: " + loginPassword);

        Map ret = userBasicSearvice.login(loginAccount,loginPassword);
        int retcode = Integer.parseInt(ret.get("retcode").toString());
        System.out.println("retcode: " + retcode);
        if (retcode == 2){
            msg = "该用户不存在";
        }else if (retcode == 1){
            msg = "密码错误";
        }else if (retcode == 0){
            //将用户信息存入session
            CustomerEntity customer = (CustomerEntity) ret.get("customerInfo");
            request.getSession().setAttribute("customerInfo",customer);
            msg = "欢迎回来，" + customer.getName();
        }
        result.put("retcode",retcode);
        result.put("msg",msg);
        return result;
    }

    //0-成功，1-已收藏，-1-未登录
    @RequestMapping(value = "/jsp/user/collect", method = RequestMethod.POST)
    @ResponseBody
    public Map collectFrame(){
        Map result = new HashMap();
        int retcode;
        CustomerEntity customerEntity = (CustomerEntity) request.getSession().getAttribute("customerInfo");
        //未登录的情况
        if (customerEntity == null){
            retcode = -1;
        }else{
            String userId = customerEntity.getCustomerId();
            Integer frameId = Integer.parseInt(request.getParameter("frameId"));
            System.out.println("UserBasicController: 开始收藏 user: " + userId + "  frame: " + frameId);
            retcode = userBasicSearvice.collect(userId,frameId);
        }
        result.put("retcode",retcode);
        return result;
    }

    @RequestMapping(value = "/jsp/user/uncollect",method = RequestMethod.POST)
    @ResponseBody
    public Map uncollectFrame(){
        Map result = new HashMap();
        int retcode;
        CustomerEntity customerEntity = (CustomerEntity) request.getSession().getAttribute("customerInfo");
        //未登录的情况
        if (customerEntity == null){
            retcode = -1;
        }else{
            String userId = customerEntity.getCustomerId();
            Integer frameId = Integer.parseInt(request.getParameter("frameId"));
            System.out.println("UserBasicController: 开始取消收藏 user: " + userId + "  frame: " + frameId);
            retcode = userBasicSearvice.uncollect(userId,frameId);
        }

        result.put("retcode",retcode);
        return result;
    }
}
