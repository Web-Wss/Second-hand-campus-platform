package shop.massz.service;



import shop.massz.dao.GoodsDao;
import shop.massz.domain.GoodsBean;

import java.util.List;

public class GoodGoodsService {
    public static List<GoodsBean> getGoodGoods() {
        List<GoodsBean> result = GoodsDao.getGoodGoods();
        return result;
    }
}
