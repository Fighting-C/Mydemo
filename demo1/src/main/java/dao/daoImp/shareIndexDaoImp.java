package dao.daoImp;

import dao.ShareIndexDao;
import entity.Share;
import entity.ShareIndex;
import org.apache.ibatis.session.SqlSession;
import utils.SqlSessionUtils;

import java.util.List;

/**
 * @PackageName:dao.daoImp
 * @Date:2022/4/2513:56
 **/
public class shareIndexDaoImp implements ShareIndexDao {
    @Override
    public int deleteByPrimaryKey(Integer indexId) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            sqlSession.delete("dao.ShareIndexDao.deleteByPrimaryKey",indexId);
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
    public int insert(ShareIndex record) {
        return 0;
    }

    @Override
    public int insertselective(ShareIndex record) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            sqlSession.insert("dao.ShareIndexDao.insertselective",record);
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
    public ShareIndex selectByPrimaryKey(Integer indexId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(ShareIndex record) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();

        try {
            sqlSession.update("dao.ShareIndexDao.updateByPrimaryKeySelective",record);
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
    public int updateByPrimaryKey(ShareIndex record) {
        return 0;
    }

    @Override
    public List<ShareIndex> selectByProId(Integer proid) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        List<ShareIndex> list = null;
        try {
            list = sqlSession.selectList("dao.ShareIndexDao.selectByProId",proid);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return list;
    }

    @Override
    public List<ShareIndex> selectByName(String name) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        List<ShareIndex> list = null;
        try {
            list = sqlSession.selectList("dao.ShareIndexDao.selectByName",name);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return list;
    }
}
