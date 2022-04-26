package Demo;

import entity.ShareIndex;
import service.shareIndexService;
import org.junit.Test;
import service.shareService;

/**
 * @PackageName:Demo
 * @Date:2022/4/2514:42
 **/
public class test_shareIndex {
    @Test
    public void test1() {
        shareService shareService = new shareService();
        shareService.selectByName("产品");
    }
}
