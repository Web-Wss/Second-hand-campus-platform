package shop.massz.service;


import shop.massz.dao.CheckCodeDao;

public class CheckCodeService {
    public static void setCode(String codekey, String code) {
        CheckCodeDao.setCode(codekey,code);
    }
}
