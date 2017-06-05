package controller.Search;

import controller.BaseController;
import model.CommentEntity;
import model.FrameEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.SearchService.ISearchService;
import service.SearchService.Impl.SearchServiceImpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by joy12 on 2017/5/28.
 * 功能1：通过id找到frame，并加载单个frame展示页面
 */
@Controller("singleItemController")
public class SingleItemController extends BaseController {
    @Resource
    private ISearchService searchService = new SearchServiceImpl();

    @RequestMapping(value = "/jsp/search/getSingleItem")
    @ResponseBody
    public Map toSingleItem(HttpServletRequest request){
        Map result = new HashMap();
        Integer frameId = Integer.parseInt(request.getParameter("thisframeId"));

        FrameEntity frameInfo = searchService.getFrameByFrameId(frameId);
        if (frameInfo != null){
            result.put("msg","success");
            result.put("frameInfo",frameInfo);
            List<CommentEntity> commentList = searchService.getAllCommentsByFrameId(frameId);
            result.put("commentList",commentList);
            System.out.println("找到关于frameId：" + frameId + "的" + commentList.size() + "条评论");
        }else{
            result.put("msg","failure");
        }

        return result;
    }

    //分页还没做
//    @RequestMapping(value = "/jsp/search/getCommentsByPage",method = RequestMethod.POST)
//    @ResponseBody
//    public Map getCommentsByPage(HttpServletRequest request){
//        Map result = new HashMap();
//        Integer frameId = Integer.parseInt(request.getParameter("frameId"));
//        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
//    //    int pageSize = Integer.parseInt(request.getParameter("pageSize"));
//
//        List<CommentEntity> commentList = new ArrayList<CommentEntity>();
//        commentList.addAll(searchService.getAllCommentsByFrameId(frameId));
//
//        result.put("commentList", commentList);
//
//        return result;
//    }
}
