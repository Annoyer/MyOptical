package interceptor;

import model.CustomerEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by joy12 on 2017/6/6.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("使用拦截器LoginInterceptor中的preHandle");
        CustomerEntity customerInfo = (CustomerEntity) httpServletRequest.getSession().getAttribute("customerInfo");
        if (customerInfo == null){
            System.out.println("尚未登录，跳到登录页面");
            PrintWriter out = httpServletResponse.getWriter();
            out.write("<script language=javascript>alert('请先登录!');</script");
            out.flush();
            httpServletResponse.sendRedirect("login.jsp");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("使用拦截器LoginInterceptor中的postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("使用拦截器LoginInterceptor中的afterCompletion");
        CustomerEntity customerInfo = (CustomerEntity) httpServletRequest.getSession().getAttribute("customerInfo");
        if (customerInfo == null){
            System.out.println("尚未登录");
            PrintWriter out = httpServletResponse.getWriter();
            out.write("<script language=javascript>alert('请先登录!');</script");
            out.flush();
            httpServletResponse.sendRedirect("login.jsp");
        }
    }
}
