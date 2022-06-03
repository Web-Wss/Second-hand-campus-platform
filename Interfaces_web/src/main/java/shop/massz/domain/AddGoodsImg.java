package shop.massz.domain;

import java.util.Arrays;

public class AddGoodsImg {
    private int goods_id;
    private String[] goods_img;

    public AddGoodsImg() {
    }

    public AddGoodsImg(int goods_id, String[] goods_img) {
        this.goods_id = goods_id;
        this.goods_img = goods_img;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String[] getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String[] goods_img) {
        this.goods_img = goods_img;
    }

    @Override
    public String toString() {
        return "AddGoodsImg{" +
                "goods_id=" + goods_id +
                ", goods_img=" + Arrays.toString(goods_img) +
                '}';
    }
}
