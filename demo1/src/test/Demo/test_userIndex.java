import entity.User;
import org.junit.Test;
import service.userIndexService;

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

        System.out.println("见到啦副驾驶的离开飞机啊");
    }
}
