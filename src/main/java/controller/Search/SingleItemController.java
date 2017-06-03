package controller.Search;

import controller.BaseController;
import model.CommentEntity;
import model.FrameEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.SearchService.ISearchService;
import service.SearchService.Impl.SearchServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joy12 on 2017/5/28.
 * 功能1：通过id找到frame，并加载单个frame展示页面
 */
@Controller("singleItemController")
public class SingleItemController extends BaseController {
    @Autowired
    private HttpServletRequest request;

    private ISearchService searchService = new SearchServiceImpl();

    @RequestMapping(value = "/jsp/single_item")
    public ModelAndView toSingleItem(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("single_item");
        String frameId = request.getParameter("frameId");

        FrameEntity frameInfo = searchService.getFrameByFrameId(frameId);

        if (frameInfo != null){
            List<CommentEntity> commentList = new ArrayList<CommentEntity>();
            commentList.addAll(searchService.getCommentsByFrameId(frameId));
            mv.addObject("msg","success");
            mv.addObject("frameInfo",frameInfo);
            mv.addObject("commentList", commentList);
            mv.addObject("commentListSize", commentList.size());
        }else{
            mv.addObject("msg","failure");
        }

        return mv;
    }
}
