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


    //返回总管理资产
    public int allManageMoney() {
        List<Production> list = this.SelectAllPro();
        int sum = 0;
        for (Production production1 : list) {
            if (production1.getProStatus().equals("运营中")) {
                sum += production1.getProManage();
            }
        }
        return sum;
    }

    public int updateByPrimaryKeySelective(Production production) {
        return productionDaoImp.updateByPrimaryKeySelective(production);
    }
    public Production selectByPrimaryKey(Integer proId) {
        return productionDaoImp.selectByPrimaryKey(proId);
    }
}
