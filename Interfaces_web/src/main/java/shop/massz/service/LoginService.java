package shop.massz.service;


import shop.massz.dao.LoginDao;
import shop.massz.domain.UserBean;

public class LoginService {
    public static UserBean Login(String user_username, String user_password) {
        UserBean result = LoginDao.Login(user_username,user_password);
        return result;
    }
}
