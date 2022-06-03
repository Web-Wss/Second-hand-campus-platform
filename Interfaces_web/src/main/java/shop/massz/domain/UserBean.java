package shop.massz.domain;

public class UserBean {
    private int user_id;
    private String user_username;
    private String user_password;
    private String user_nickname;
    private String user_phone;
    private String user_qq;
    private String user_wx;
    private String user_img;
    private String user_status;
    private String user_address;

    public UserBean() {
    }

    public UserBean(int user_id, String user_username, String user_password, String user_nickname, String user_phone, String user_qq, String user_wx, String user_img, String user_status, String user_address) {
        this.user_id = user_id;
        this.user_username = user_username;
        this.user_password = user_password;
        this.user_nickname = user_nickname;
        this.user_phone = user_phone;
        this.user_qq = user_qq;
        this.user_wx = user_wx;
        this.user_img = user_img;
        this.user_status = user_status;
        this.user_address = user_address;
    }

    public UserBean(int user_id, String user_username, String user_nickname, String user_password, String user_status) {
        this.user_id = user_id;
        this.user_username = user_username;
        this.user_nickname = user_nickname;
        this.user_password = user_password;
        this.user_status = user_status;
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_qq() {
        return user_qq;
    }

    public void setUser_qq(String user_qq) {
        this.user_qq = user_qq;
    }

    public String getUser_wx() {
        return user_wx;
    }

    public void setUser_wx(String user_wx) {
        this.user_wx = user_wx;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "user_id=" + user_id +
                ", user_username='" + user_username + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_nickname='" + user_nickname + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_qq='" + user_qq + '\'' +
                ", user_wx='" + user_wx + '\'' +
                ", user_img='" + user_img + '\'' +
                ", user_status='" + user_status + '\'' +
                ", user_address='" + user_address + '\'' +
                '}';
    }
}
