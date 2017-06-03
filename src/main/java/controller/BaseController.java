package controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 11022 on 2017/2/1.
 */
public abstract class BaseController {

    @Autowired
    protected HttpServletRequest request;

}

