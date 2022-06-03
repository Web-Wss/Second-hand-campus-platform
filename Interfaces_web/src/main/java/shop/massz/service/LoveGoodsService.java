package shop.massz.service;



import shop.massz.dao.LoveGoodsDao;
import shop.massz.domain.LoveGoodsBean;

import java.util.List;

public class LoveGoodsService {

//    获取用户喜欢的商品信息
    public static List<LoveGoodsBean> getLoveGoods(String user_id) {
        List<LoveGoodsBean> result = LoveGoodsDao.getLoveGoods(user_id);
        return result;
    }

//        删除当前用户喜欢的商品，根据love_id
    public static boolean deleteGoods(String love_id) {
        boolean result = LoveGoodsDao.deleteGoods(love_id);
        return result;
    }
//获取love_id
    public static int getMaxLoveId() {
        int result = LoveGoodsDao.getMaxLoveId();
        return result;
    }
//向表中添加收藏的商品
    public static boolean addLoveGoods(LoveGoodsBean loveGoodsBean) {
        boolean result = LoveGoodsDao.addLoveGoods(loveGoodsBean);
        return result;
    }
//查询收藏库中有没有当前的用户收藏此商品
    public static boolean queryLoveGoods(String goods_id, String user_id) {
        boolean result = LoveGoodsDao.queryLoveGoods(goods_id, user_id);
        return result;
    }
}
