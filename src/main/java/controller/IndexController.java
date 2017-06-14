package controller;

import model.FrameEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.index.IIndexService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 11022 on 2017/5/20.
 */
@Controller("index")
public class IndexController extends BaseController {
    @Resource
    protected IIndexService indexService;

    @RequestMapping(value = "/jsp/index")
    public ModelAndView toIndex(){
        System.out.println("访问主页");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        List<FrameEntity> man = indexService.getBestSeller("userType","男款");
        List<FrameEntity> woman = indexService.getBestSeller("userType","女款");
        List<FrameEntity> sun = indexService.getBestSeller("glassesType","太阳眼镜");

        mv.addObject("man",man);
        mv.addObject("woman",woman);
        mv.addObject("sun",sun);
        return mv;
    }
}
