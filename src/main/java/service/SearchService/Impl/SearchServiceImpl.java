package service.SearchService.Impl;

import model.CommentEntity;
import model.FrameEntity;
import org.springframework.stereotype.Service;
import service.SearchService.ISearchService;
import service.common.impl.CommServiceImpl;

import java.util.*;

/**
 * Created by joy12 on 2017/5/28.
 * 功能1：根据属性集获取frameEntity列表
 * 功能2：根据关键词获取frameEntity列表
 * 功能3：根据frameId获取frameEntity对象
 * 功能4：根据frameId获取评论信息
 */
@Service(value = "ISearchService")
public class SearchServiceImpl extends CommServiceImpl implements ISearchService{
    @Override
    public List<FrameEntity> getFramesByAttrs(Map<String, String> attrMap) {
        List<FrameEntity> result = baseDAO.findFramesByAttr(attrMap);
        System.out.println("SearchService: getFramesByAttrs()查找结束，共找到" + result.size() + "个结果");

        return result;
    }

    @Override
    public Set<FrameEntity> getFramesByKeyword(String keyword) {
        Set<FrameEntity> result = new HashSet<FrameEntity>();
        String[] attrs = {"frameName","userType","color","style","form","material"};
        for (int i=0; i<attrs.length; i++){
            String sql = "from FrameEntity as f where f." + attrs[i] + " like '%" + keyword + "%'";
            System.out.println("sql:" + sql);
            result.addAll(baseDAO.find(sql));
        }

        System.out.println("SearchService: getFramesByKeyword()查找结束，共找到" + result.size() + "个结果");

        return result;
    }

    @Override
    public FrameEntity getFrameByFrameId(Integer frameId) {
        FrameEntity frameInfo = baseDAO.findById(frameId,FrameEntity.class);
        Integer times = frameInfo.getAccessTime();
        if (times == null){
            frameInfo.setAccessTime(1);
        }else {
            frameInfo.setAccessTime(times+1);
        }
        baseDAO.update(frameInfo);
        return frameInfo;
    }

    @Override
    public List<CommentEntity> getAllCommentsByFrameId(Integer frameId) {
    //    List<CommentEntity> commentEntityList = baseDAO.getCommentsByPage(frameId,pageNum,pageSize);
        List<CommentEntity> commentEntityList = new ArrayList<CommentEntity>();
        commentEntityList.addAll(baseDAO.findByProperty("frameId",frameId,CommentEntity.class));
        return commentEntityList;
    }

}
