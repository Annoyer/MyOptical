package controller.Search;

import controller.BaseController;
import model.FrameEntity;
import org.apache.commons.collections.map.HashedMap;
import org.omg.CORBA.Object;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
 * 功能1：根据前台选择面板中传来的参数到后台拉取所有对应眼镜的信息
 * 功能2：使用header中的搜索栏进行关键字搜索
 * 功能3：header里的导航栏到search_result页面跳转，用1中的查找函数（换成单属性）
 */
@Controller("searchController")
public class SearchController extends BaseController {
    @Resource
    private ISearchService searchService = new SearchServiceImpl();

    //使用required = false时，若前台没有这个参数，会赋值null
    @RequestMapping(value = "/jsp/search/firstLoad",method=RequestMethod.POST)
    @ResponseBody
    public Map toSearchItems(HttpServletRequest request){
        Map result = new HashMap();
        List<FrameEntity> frames = new ArrayList<FrameEntity>();
        String msg;
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        String keyWord = request.getParameter("keyWord");
        System.out.println("key=" + key);
        System.out.println("value=" + value);
        System.out.println("keyWord=" + keyWord);
        if (!key.isEmpty() && !value.isEmpty() && keyWord.isEmpty()){
            System.out.println("SearchController：得到key: " + key + "  value: " + value);
            Map<String,String> attrMap = new HashMap<String, String>();
            attrMap.put(key,":"+value);
            frames.addAll(searchService.getFramesByAttrs(attrMap));
        } else if (key.isEmpty() && value.isEmpty() && !keyWord.isEmpty()){
            System.out.println("SearchController：得到keyWord: " + keyWord);
            frames.addAll(searchService.getFramesByKeyword(keyWord));
        } else {
            System.out.println("SearchController：前台参数错误");
        }

        System.out.println("search/framesize=" + frames.size());
        if (frames.size() > 0){
            msg = "success";
            result.put("framelist",frames);
        } else {
            msg = "no_result";
        }

        result.put("msg", msg);
        return result;
    }

    @RequestMapping(value = "/jsp/search/panelOptions", method = RequestMethod.POST)
    @ResponseBody
    public Map searchByPanel(HttpServletRequest request){
        System.out.println("start panelOptions");
        Map result = new HashMap();
        List<FrameEntity> frames = new ArrayList<FrameEntity>();
        Map<String,String> attrMap = new HashMap<String, String>();
        String msg;

        attrMap.put("userType",request.getParameter("userType"));
        attrMap.put("glassesType",request.getParameter("glassesType"));
        attrMap.put("color",request.getParameter("color"));
        attrMap.put("style",request.getParameter("style"));
        attrMap.put("material",request.getParameter("material"));
        attrMap.put("form",request.getParameter("form"));
        frames.addAll(searchService.getFramesByAttrs(attrMap));
        System.out.println("SearchController: panelOptions: listsize=" + frames.size());

        if (frames.size() > 0){
            msg = "success";
            result.put("framelist",frames);
        } else {
            msg = "no_result";
        }

        result.put("msg", msg);
        return result;
    }
}
