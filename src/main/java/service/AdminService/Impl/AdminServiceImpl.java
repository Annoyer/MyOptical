package service.AdminService.Impl;

import model.CustomerEntity;
import model.FrameEntity;
import model.ManagerEntity;
import org.springframework.stereotype.Service;
import service.AdminService.IAdminService;
import service.common.impl.CommServiceImpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by joy12 on 2017/6/8.
 */
@Service("AdminService")
public class AdminServiceImpl extends CommServiceImpl implements IAdminService {

    @Override
    //2-用户不存在 1-密码错误 0-成功
    public Map adminLogin(String id, String password) {
        Map result = new HashMap();
        int retcode = 0;
        ManagerEntity managerInfo = baseDAO.findById(id,ManagerEntity.class);

        if (managerInfo == null){
            retcode = 2;
        }else if (!managerInfo.getManagerPassword().contentEquals(password)){
            retcode = 1;
        }else {
            result.put("managerInfo",managerInfo);
        }
        result.put("retcode",retcode);
        return result;
    }

    @Override
    //1-货物不存在 0-成功
    public int deleteFrame(Integer frameId) {
        int retCode = 0;
        FrameEntity frameEntity = baseDAO.findById(frameId,FrameEntity.class);
        if (frameEntity != null){
            baseDAO.delete(frameEntity);
        }else {
            retCode = 1;
        }
        return retCode;
    }

    @Override
    public void addFrame(String frameName, String framePrice, String framePhoto, String userType,
                         String glassesType, String color, String style, String material, String form,
                         String lensWidth, String lensHeight, String bridgeWidth, String templeLength) {
        String sql="insert into frame"+
                "(frame_name,glasses_type,user_type,frame_price,color,style,form,material,frame_photo,lens_width,lens_height,bridge_width,temple_length,access_time) "+
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int lh = 0;
        int lw = 0;
        int bw = 0;
        int tl = 0;
        if (lensWidth != null) lh = Integer.parseInt(lensWidth);
        if (lensHeight != null) lw = Integer.parseInt(lensHeight);
        if (templeLength != null) bw = Integer.parseInt(templeLength);
        if (bridgeWidth != null) tl = Integer.parseInt(bridgeWidth);
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(framePrice));
        baseDAO.executeSQL(sql, new Object[]{frameName,glassesType,userType,price,color,style,form,material,framePhoto,lw,lh,bw,tl,0});
    }


}
