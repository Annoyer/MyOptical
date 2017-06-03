package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.index.IIndexService;

import javax.annotation.Resource;

/**
 * Created by 11022 on 2017/5/20.
 */
@Controller("index")
public class Index extends BaseController {
    @Resource
    protected IIndexService indexService;

    @RequestMapping(value = "/jsp/index")
    public String toIndex(){
        return "index";
    }
}
