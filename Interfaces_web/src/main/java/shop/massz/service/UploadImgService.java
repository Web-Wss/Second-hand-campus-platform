package shop.massz.service;


import shop.massz.dao.UploadImgDao;
import shop.massz.domain.AddGoodsImg;
import shop.massz.domain.GoodsBean;

public class UploadImgService {
//获取数据库商品编号最大值
    public static int GoodsMaxId() {
        int result = UploadImgDao.getGoodsMaxId();
        return result;
    }

//    向数据库中添加商品信息
    public static boolean addGoods(GoodsBean goodsBean) {
        boolean b = UploadImgDao.addGoods(goodsBean);
        return b;
    }

    public static void addImg(AddGoodsImg addGoodsImg) {
        UploadImgDao.addImg(addGoodsImg);
    }
}
