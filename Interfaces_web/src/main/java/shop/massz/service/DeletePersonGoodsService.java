package shop.massz.service;

import shop.massz.dao.DeleteGoodsDao;
import shop.massz.domain.GoodsBean;

import java.io.File;
import java.util.List;

public class DeletePersonGoodsService {

    public static void delete(String goods_id, String path) {
//        查询商品图片列表，删除服务器中的图片
        List<GoodsBean> list = DeleteGoodsDao.getGoodsImgs(goods_id);
        list.stream().forEach(goods_img->{
//            System.out.println(path + goods_img.getGoods_img());
            String imgs = goods_img.getGoods_img();
            System.out.println(path +"\\"+ imgs.substring(imgs.lastIndexOf("/")+1));
            File delImg = new File(path + "\\"+ imgs.substring(imgs.lastIndexOf("/")+1));
            if (delImg.exists()) {
                delImg.delete();
            }
        });
//        删除数据库中img表中的记录
        DeleteGoodsDao.deleteGoodsImg(goods_id);
//        删除goods表中的记录
        DeleteGoodsDao.deleteGoods(goods_id);

    }
}
