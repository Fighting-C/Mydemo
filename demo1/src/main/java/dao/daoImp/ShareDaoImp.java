package dao.daoImp;

import dao.SharesDao;
import entity.Share;
import org.apache.ibatis.session.SqlSession;
import utils.SqlSessionUtils;

import java.util.List;

/**
 * @PackageName:dao.daoImp
 * @Date:2022/4/2121:09
 **/
public class ShareDaoImp implements SharesDao {
    @Override
    public int deleteByPrimaryKey(Integer shareId) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            sqlSession.delete("dao.SharesDao.deleteByPrimaryKey", shareId);
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
    public int insert(Share record) {
        return 0;
    }

    @Override
    public int insertSelective(Share record) {
        return 0;
    }

    @Override
    public Share selectByPrimaryKey(Integer shareId) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        Share share =null;
        try {
            share = sqlSession.selectOne("dao.SharesDao.selectByPrimaryKey",shareId);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return share;
    }

    @Override
    public int updateByPrimaryKeySelective(Share record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Share record) {
        return 0;
    }

    @Override
    public List<Share> getAllShare() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        List<Share> list = null;
        try {
            list = sqlSession.selectList("dao.SharesDao.getAllShare");
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return list;
    }

    @Override
    public List<Share> selectByName(String name) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        List<Share> list = null;
        try {
            list = sqlSession.selectList("dao.SharesDao.selectByName",name);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return list;
    }
}
