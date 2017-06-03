package service.index.impl;

import org.springframework.stereotype.Service;
import service.common.impl.CommServiceImpl;
import service.index.IIndexService;

/**
 * Created by 11022 on 2017/5/20.
 */
@Service(value = "IIndexService")
public class IndexServiceImpl extends CommServiceImpl implements IIndexService {

    @Override
    public int test() {
        return 0;
    }
}
