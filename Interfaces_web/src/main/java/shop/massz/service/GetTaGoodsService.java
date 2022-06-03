package shop.massz.service;

import shop.massz.dao.GetTaGoodsDao;
import shop.massz.domain.GoodsBean;
import shop.massz.domain.LoveGoodsBean;

import java.util.List;

public class GetTaGoodsService {
    public static List<GoodsBean> getTaGoods(int user_id) {
        List<GoodsBean> result = GetTaGoodsDao.getTaGoods(user_id);
        return result;
    }
}
