package dao.daoImp;

import dao.UserDao;
import entity.Production;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import utils.SqlSessionUtils;

import java.util.List;

/**
 * @PackageName:service
 * @Date:2022/3/115:00
 **/


public class UserDaoImp implements UserDao {
    @Override

    /**
     * 通过用户名查找对应用户
     */
    public User selectByUserNumber(String usernumber) {
        User user = null;
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
           user= sqlSession.selectOne("dao.UserDao.selectByUserNumber", usernumber);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return user;
    }

    //按照userid删除信息
    @Override
    public int deleteByPrimaryKey(Integer userId) {

        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            sqlSession.delete("dao.UserDao.deleteByPrimaryKey", userId);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            sqlSession.close();
        }
        return 1;
    }

    //新增user信息
    @Override
    public int insert(User record) {

        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            sqlSession.insert("dao.UserDao.insert", record);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            sqlSession.close();
        }
        return 1;
    }



    @Override
    public int insertSelective(User record) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            sqlSession.insert("dao.UserDao.insertSelective", record);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            sqlSession.close();
        }
        return 1;
    }



    //由userid查找user信息
    @Override
    public User selectByPrimaryKey(Integer userId) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        User user = null;
        try {
            user = sqlSession.selectOne("dao.UserDao.selectByPrimaryKey", userId);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    return user;
    }

    //此处record为选择性修改
    @Override
    public int updateByPrimaryKeySelective(User record) {
        SqlSession sqlSession =SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            sqlSession.update("dao.UserDao.updateByPrimaryKeySelective",record);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            sqlSession.close();
        }
        return 1;

    }

    //此处record需全不为空
    @Override
    public int updateByPrimaryKey(User record) {
        SqlSession sqlSession =SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            sqlSession.update("dao.UserDao.updateByPrimaryKey");
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }


    //查找所有User信息
    @Override
    public List<User> selectAllUsers() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        List<User> list = null;
        try {
            list = sqlSession.selectList("dao.UserDao.selectAllUsers");
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return list;
    }

}
