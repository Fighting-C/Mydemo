import entity.User;
import org.junit.Test;
import service.userIndexService;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @PackageName:PACKAGE_NAME
 * @Date:2022/3/117:19
 **/
public class test_userIndex {
    @Test
    public void test1() {
        userIndexService userIndexService = new userIndexService();
        User user = new User();
        user.setUserId(2);

        System.out.println(userIndexService.SelectByUserId(user));
    }

    @Test
    public void test2() {
        for (int i = 0; i < 100; i++) {
            System.out.println(BigDecimal.ZERO.setScale(2,2));
        }

    }
}
