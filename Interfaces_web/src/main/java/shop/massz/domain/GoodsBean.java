package shop.massz.domain;

import java.util.Date;

public class GoodsBean {
    private  String sort_name;
    private int goods_id;//商品id
    private int sort_id;//分类id
    private String goods_name;//商品名称
    private String goods_price;//商品价格
    private String goods_describe;//商品描述
    private Date goods_time;//商品发布时间
    private int user_id;//用户id

    private int id;//图片表id
    private String goods_img;//商品图片

    private String user_username;
    private String user_nickname;
    private String user_phone;
    private String user_wx;


    public GoodsBean() {
    }

    public GoodsBean(int goods_id, int sort_id, String goods_name, String goods_price, String goods_describe, Date goods_time, int user_id, int id, String goods_img) {
        this.goods_id = goods_id;
        this.sort_id = sort_id;
        this.goods_name = goods_name;
        this.goods_price = goods_price;
        this.goods_describe = goods_describe;
        this.goods_time = goods_time;
        this.user_id = user_id;
        this.id = id;
        this.goods_img = goods_img;
    }

    public GoodsBean(int goods_id, int sort_id, String goods_name, String goods_price, String goods_describe, java.sql.Date goods_time, int user_id, int id, String goods_img, String user_username, String user_nickname, String user_phone, String user_wx) {
        this.goods_id = goods_id;
        this.sort_id = sort_id;
        this.goods_name = goods_name;
        this.goods_price = goods_price;
        this.goods_describe = goods_describe;
        this.goods_time = goods_time;
        this.user_id = user_id;
        this.id = id;
        this.goods_img = goods_img;
        this.user_username = user_username;
        this.user_nickname = user_nickname;
        this.user_phone = user_phone;
        this.user_wx = user_wx;
    }

    public GoodsBean(int goods_id, int sort_id, String goods_name, String goods_price, String goods_describe, Date goods_time, int user_id) {
        this.goods_id = goods_id;
        this.sort_id = sort_id;
        this.goods_name = goods_name;
        this.goods_price = goods_price;
        this.goods_describe = goods_describe;
        this.goods_time = goods_time;
        this.user_id = user_id;
    }

    public GoodsBean(String goods_img) {
        this.goods_img = goods_img;
    }

    public GoodsBean(String goods_name, String goods_img, String goods_price, int goods_id) {
        this.goods_name = goods_name;
        this.goods_img = goods_img;
        this.goods_price = goods_price;
        this.goods_id = goods_id;
    }

    public GoodsBean(int goods_id, String sort_name, String goods_name, String goods_img, String user_nickname) {
        this.goods_id = goods_id;
        this.sort_name = sort_name;
        this.goods_name = goods_name;
        this.goods_img = goods_img;
        this.user_nickname = user_nickname;
    }

    public String getSort_name() {
        return sort_name;
    }

    public void setSort_name(String sort_name) {
        this.sort_name = sort_name;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getSort_id() {
        return sort_id;
    }

    public void setSort_id(int sort_id) {
        this.sort_id = sort_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(String goods_price) {
        this.goods_price = goods_price;
    }

    public String getGoods_describe() {
        return goods_describe;
    }

    public void setGoods_describe(String goods_describe) {
        this.goods_describe = goods_describe;
    }

    public Date getGoods_time() {
        return goods_time;
    }

    public void setGoods_time(Date goods_time) {
        this.goods_time = goods_time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
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

    public String getUser_wx() {
        return user_wx;
    }

    public void setUser_wx(String user_wx) {
        this.user_wx = user_wx;
    }

    @Override
    public String toString() {
        return "GoodsBean{" +
                "goods_id=" + goods_id +
                ", sort_id=" + sort_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_price='" + goods_price + '\'' +
                ", goods_describe='" + goods_describe + '\'' +
                ", goods_time=" + goods_time +
                ", user_id=" + user_id +
                ", id=" + id +
                ", goods_img='" + goods_img + '\'' +
                '}';
    }
}
