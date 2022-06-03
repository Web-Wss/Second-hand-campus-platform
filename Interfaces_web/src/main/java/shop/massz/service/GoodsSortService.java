package shop.massz.service;



import shop.massz.dao.GoodsSortDao;
import shop.massz.domain.GoodsSortBean;

import java.util.List;

public class GoodsSortService {

    public static Object getGoodsSort() {
        List<GoodsSortBean> result = GoodsSortDao.getGoodsSort();
        return result;
    }
}
