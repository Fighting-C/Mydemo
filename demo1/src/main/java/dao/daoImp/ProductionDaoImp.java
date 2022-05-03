package dao.daoImp;

import dao.ProductionDao;
import entity.Production;
import org.apache.ibatis.session.SqlSession;
import utils.SqlSessionUtils;

import java.util.List;

/**
 * @PackageName:dao
 * @Date:2022/3/116:38
 **/
public class ProductionDaoImp implements ProductionDao {
    @Override
    public int deleteByPrimaryKey(Integer proId) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            sqlSession.delete("dao.ProductionDao.deleteByPrimaryKey", proId);
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
    //完整插入
    public int insert(Production record) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            sqlSession.insert("dao.ProductionDao.insert",record);
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
    //选择性插入
    public int insertSelective(Production record) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            sqlSession.insert("dao.ProductionDao.insertSelective",record);
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
    public Production selectByPrimaryKey(Integer proId) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        Production production = null;
        try {
            production = sqlSession.selectOne("dao.ProductionDao.selectByPrimaryKey", proId);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            sqlSession.close();
        }
        return production;
    }

    @Override
    //通过Proid修改部分
    public int updateByPrimaryKeySelective(Production record) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            sqlSession.update("dao.ProductionDao.updateByPrimaryKeySelective", record);
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
    //通过Proid修改全部
    public int updateByPrimaryKey(Production record) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            sqlSession.update("dao.ProductionDao.updateByPrimaryKey", record);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            sqlSession.close();
        }
        return 1;
    }

    //返回所有产品信息
    @Override
    public List<Production> selectAllPro() {
        SqlSession sqlSession =SqlSessionUtils.getSqlSessionFactory().openSession();
        List<Production> list = null;
        try {
            list = sqlSession.selectList("dao.ProductionDao.selectAllPro");
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return list;

    }
}
