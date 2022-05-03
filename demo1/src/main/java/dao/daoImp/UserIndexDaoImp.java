package dao.daoImp;

import dao.UserIndexDao;
import entity.User;
import entity.UserIndex;
import org.apache.ibatis.session.SqlSession;
import utils.SqlSessionUtils;

/**
 * @PackageName:dao
 * @Date:2022/3/116:36
 **/
public class UserIndexDaoImp implements UserIndexDao {


    //完全信息增加
    @Override
    public int insert(UserIndex record) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();

        try {
            sqlSession.insert("dao.UserIndexDao.insert", record);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            sqlSession.close();
        }
        return 1;
    }


    //不完全信息增加
    @Override
    public int insertSelective(UserIndex record) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();

        try {
            sqlSession.insert("dao.UserIndexDao.insertSelective", record);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            sqlSession.close();
        }
        return 1;
    }

    @Override
    /**
     * 通过userid修改信息
     */
    public int updateSelective(UserIndex record) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            sqlSession.update("dao.UserIndexDao.updateSelective", record);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            sqlSession.close();
        }
        return 1;
    }


    @Override
    /**
     * 通过userid 查找相应userindex
     *
     */
    public UserIndex selectUserIndexById(User record) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        UserIndex userIndex = null;
        try {
            userIndex = sqlSession.selectOne("dao.UserIndexDao.selectUserIndexById", record);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return userIndex;

    }
}
