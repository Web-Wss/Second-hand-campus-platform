package shop.massz.service.root;

import shop.massz.dao.root.RootUserDao;
import shop.massz.domain.UserBean;

public class UserService {
    public static Object searchUser(String value) {
        return RootUserDao.searchUser(value);
    }

    public static Object getUserList(int currentPage) {
        return RootUserDao.getUserList(currentPage);
    }

    public static int userTotal() {
        return RootUserDao.userTotal();
    }

//    修改用户状态
    public static boolean editUserStatus(int user_id, int status) {
        return RootUserDao.editUserStatus(user_id,status);
    }
//修改用户信息
    public static boolean editUserInfo(UserBean userBean) {
        return RootUserDao.editUserInfo(userBean);
    }

//    删除用户
    public static boolean deleteUser(int user_id) {
        return RootUserDao.deleteUser(user_id);
    }

    public static boolean addUser(UserBean userBean) {
        return RootUserDao.addUser(userBean);
    }
}
