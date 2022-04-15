import dao.daoImp.ProductionDaoImp;
import entity.Production;
import org.junit.Test;

import java.util.List;

/**
 * @PackageName:PACKAGE_NAME
 * @Date:2022/4/211:20
 **/
public class test_pro {
    @Test
    public void test1() {
        ProductionDaoImp productionDaoImp = new ProductionDaoImp();
        List<Production> list = productionDaoImp.selectAllPro();
        System.out.println(list);

    }
}
