package shop.massz.service;



import shop.massz.dao.GoodsDao;
import shop.massz.domain.GoodsBean;

import java.util.List;

public class QueryService {

    public static List<GoodsBean> queryGoods(String searchvalue) {
        List<GoodsBean> result = GoodsDao.queryGoods(searchvalue);
        return result;
    }
}
