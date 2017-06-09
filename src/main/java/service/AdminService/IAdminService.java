package service.AdminService;

import java.util.Map;

/**
 * Created by joy12 on 2017/6/8.
 */
public interface IAdminService {
    Map adminLogin(String id, String password);
    int deleteFrame(Integer frameId);
    void addFrame(String frameName, String framePrice, String framePhoto, String userType, String glassesType, String color, String style,
                  String material, String form, String lensWidth, String lensHeight, String bridgeWidth, String templeLength);
}
