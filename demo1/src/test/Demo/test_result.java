import entity.Result;
import org.junit.Test;

/**
 * @PackageName:PACKAGE_NAME
 * @Date:2022/3/1619:51
 **/
public class test_result {
    @Test
    public void test1() {
        Result result = new Result();
        result.setToken("admin-token");
        System.out.println(result.getToken());
    }
}
