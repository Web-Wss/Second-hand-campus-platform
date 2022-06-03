package shop.massz.service;


import shop.massz.dao.GoodsDao;
import shop.massz.domain.GoodsBean;

import java.util.List;

public class PersonGoodsService {

    public static List<GoodsBean> getPersonGoods(String user_id) {
        List<GoodsBean> result = GoodsDao.getPersonGoods(user_id);
        return result;
    }
}
