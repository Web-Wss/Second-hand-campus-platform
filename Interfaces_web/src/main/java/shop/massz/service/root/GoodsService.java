package shop.massz.service.root;

import shop.massz.dao.root.RootGoodsDao;

public class GoodsService {

    public static Object getGoodsList(int currentPage) {
        return RootGoodsDao.getGoodsList(currentPage);
    }

//    得到商品总数
    public static int goodsTotal() {
        return RootGoodsDao.goodsTotal();
    }

    public static Object searchGoods(String value) {
        return RootGoodsDao.searchGoods(value);
    }

//    搜索分类下的商品
    public static Object searchGoodsSort(String value) {
        return RootGoodsDao.searchGoodsSort(value);
    }
}
