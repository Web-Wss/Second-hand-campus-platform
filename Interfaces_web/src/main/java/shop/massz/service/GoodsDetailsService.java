package shop.massz.service;


import shop.massz.dao.GoodsDao;
import shop.massz.domain.GoodsBean;

import java.util.List;

public class GoodsDetailsService {

    public static List<GoodsBean> query(String goods_id) {
        List<GoodsBean> result = GoodsDao.getGoodsDetails(goods_id);
        return result;
    }
}
