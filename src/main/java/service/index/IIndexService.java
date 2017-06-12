package service.index;

import model.FrameEntity;
import service.common.ICommService;

import java.util.List;

/**
 * Created by 11022 on 2017/5/20.
 */
public interface IIndexService extends ICommService{
    List<FrameEntity> getBestSeller(String key, String value);
}
