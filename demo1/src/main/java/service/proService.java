package service;

import dao.daoImp.ProductionDaoImp;
import entity.Production;

import java.util.List;

/**
 * @PackageName:service
 * @Date:2022/4/211:11
 **/
public class proService {
    private ProductionDaoImp productionDaoImp = new ProductionDaoImp();
    private Production production = null;

    //返回所有产品信息
    public List<Production> SelectAllPro() {
        return productionDaoImp.selectAllPro();
    }

    //添加新产品
    public int insertSelective(Production production) {
        return productionDaoImp.insertSelective(production);
    }
}
