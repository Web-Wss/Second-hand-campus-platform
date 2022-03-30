package service.LoginService;

import Bean.LoginData;

public class LoginService {
    LoginData loginData = new LoginData();

    String sql = "select * from user where user_username=? and user_password=?";

}
