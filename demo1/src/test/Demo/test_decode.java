package Demo;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * @PackageName:Demo
 * @Date:2022/4/2110:29
 * 96e79218965eb72c92a549dd5a330112
 **/
public class test_decode {
    @Test
    public void test1() {
        System.out.println(DigestUtils.md5Hex("111111"));
    }
}
