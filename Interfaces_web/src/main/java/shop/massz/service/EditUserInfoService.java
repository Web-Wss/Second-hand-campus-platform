package shop.massz.service;


import shop.massz.dao.UserDao;
import shop.massz.domain.UserBean;

public class EditUserInfoService {
    public static boolean edituserInfo(UserBean userBean) {
        boolean result = UserDao.editUserInfo(userBean);
        return result;
    }
}
