package shop.massz.domain;

public class LoveGoodsBean {
    private int love_id;
    private int goods_id;
    private String goods_name;
    private String goods_img;
    private String goods_price;
    private int user_id;

    public LoveGoodsBean() {
    }



    public LoveGoodsBean(int love_id, int goods_id, String goods_name, String goods_img, String goods_price, int user_id) {
        this.love_id = love_id;
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_img = goods_img;
        this.goods_price = goods_price;
        this.user_id = user_id;
    }

    public int getLove_id() {
        return love_id;
    }

    public void setLove_id(int love_id) {
        this.love_id = love_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(String goods_price) {
        this.goods_price = goods_price;
    }

    @Override
    public String toString() {
        return "LoveGoodsBean{" +
                "love_id=" + love_id +
                ", goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_img='" + goods_img + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
