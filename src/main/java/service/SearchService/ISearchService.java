package service.SearchService;

import model.CommentEntity;
import model.FrameEntity;
import service.common.ICommService;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by joy12 on 2017/5/28.
 * 功能1：根据属性集获取frameEntity列表
 * 功能2：根据关键词获取frameEntity列表
 * 功能3：根据frameId获取frameEntity对象
 * 功能4：根据frameId获取评论信息
 */
public interface ISearchService extends ICommService {
    Set<FrameEntity> getFramesByAttrs(Map<String,String> attrMap);
    Set<FrameEntity> getFramesByKeyword(String keyword);
    FrameEntity getFrameByFrameId(Integer frameId);
    List<CommentEntity> getAllCommentsByFrameId(Integer frameId);
}
