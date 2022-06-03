package shop.massz.service.root;


import shop.massz.dao.root.RDeleteGoodsDao;
import shop.massz.domain.GoodsBean;

import java.io.File;
import java.util.List;

public class DeleteGoodsService {
    public static void delete(String goods_id, String path) {
        //        查询商品图片列表，删除服务器中的图片
        List<GoodsBean> list = RDeleteGoodsDao.getGoodsImg(goods_id);
        list.stream().forEach(goods_img->{
//            System.out.println(path + goods_img.getGoods_img());
            String imgs = goods_img.getGoods_img();
            System.out.println(path +"\\"+ imgs.substring(imgs.lastIndexOf("/")+1));
            File delImg = new File(path + "\\"+ imgs.substring(imgs.lastIndexOf("/")+1));
            if (delImg.exists()) {
                delImg.delete();
            }
        });
        RDeleteGoodsDao.deleteGoodsImg(goods_id);
        RDeleteGoodsDao.deleteGoods(goods_id);
    }
}
