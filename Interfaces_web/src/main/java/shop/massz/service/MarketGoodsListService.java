package shop.massz.service;



import shop.massz.dao.MarketGoodsListQuery;
import shop.massz.domain.GoodsBean;

import java.util.List;

public class MarketGoodsListService {
    public static List<GoodsBean> allGoods(String sort_id) {
        List<GoodsBean> result = MarketGoodsListQuery.allGoods(sort_id);
        return result;
    }

    public static List<GoodsBean> fyGoods(String sort_id, String val) {
        List<GoodsBean> result1 = MarketGoodsListQuery.fyGoods( sort_id, val);
        return result1;
    }
}
