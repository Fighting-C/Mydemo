import entity.User;
import org.junit.Test;
import service.userService;
import utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @PackageName:PACKAGE_NAME
 * @Date:2022/2/2816:07
 **/
public class test_userdao {
    //增
    @Test
    public void test1(){
        User user = null;
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            user = new User("123","123");
            sqlSession.insert("dao.UserDao.insert", user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
//删
    }@Test
    public void test2() {
        User user = null;
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            user = new User("123", "123");
            sqlSession.insert("dao.UserDao.insert", user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
        @Test
    public void test3(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            System.out.println(sqlSession.selectOne("dao.UserDao.selectByPrimaryKey", 2));
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void test4() {
        userService userService = new userService();
        User user = new User("approver", "111111");
        user.setUserId(25);
        System.out.println(userService.updateUser(user));
    }

    @Test
    public void test5() {
        userService userService = new userService();

        System.out.println(userService.selectByUserid(2));

    }
    @Test
    public void test6() {
        userService userService = new userService();
        User user = new User();
        user.setName("admin");
        user.setUserPassword("96e79218965eb72c92a549dd5a330112");
        System.out.println(userService.Login(user));

    }
    @Test
    public void test7() {
        userService userService = new userService();
        User user = new User();
        user.setName("admin2");
        user.setUserPassword("111111");
        System.out.println(userService.insertUser(user));

    }

}
