package shop.massz.service;


import shop.massz.dao.UserDao;
import shop.massz.domain.UserBean;

public class RegisterService {
    public static boolean register(UserBean userBean) {
        boolean result = UserDao.register(userBean);
        return result;
    }
}
