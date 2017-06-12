package service.index.impl;

import model.FrameEntity;
import org.springframework.stereotype.Service;
import service.common.impl.CommServiceImpl;
import service.index.IIndexService;

import java.util.*;

/**
 * Created by 11022 on 2017/5/20.
 */
@Service(value = "IIndexService")
public class IndexServiceImpl extends CommServiceImpl implements IIndexService {

    @Override
    public List<FrameEntity> getBestSeller(String key, String value) {
        List<FrameEntity> result = new ArrayList<FrameEntity>();
        List<FrameEntity> tmp = new ArrayList<FrameEntity>();
        tmp.addAll(baseDAO.findByProperty(key,value,FrameEntity.class));
//        if (key.contentEquals("style")){
//            tmp.addAll(baseDAO.findByProperty(key,"通用款",FrameEntity.class));
//        }

        Collections.sort(tmp, new Comparator<FrameEntity>() {
            @Override
            public int compare(FrameEntity o1, FrameEntity o2) {
                //从大到小
                return o2.getAccessTime() - o1.getAccessTime();
            }
        });
        for (int i=0; i<8; i++){
            result.add(tmp.get(i));
        }

        System.out.println(result.size());

        return result;
    }
}
