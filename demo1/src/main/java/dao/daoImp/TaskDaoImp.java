package dao.daoImp;

import dao.TaskDao;
import entity.Task;
import org.apache.ibatis.session.SqlSession;
import utils.SqlSessionUtils;

import java.util.List;

/**
 * @PackageName:dao
 * @Date:2022/4/1516:32
 **/
public class TaskDaoImp implements TaskDao {
    @Override
    public int deleteByPrimaryKey(Integer taskId) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            sqlSession.delete("dao.TaskDao.deleteByPrimaryKey", taskId);
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
    public int insert(Task record) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            sqlSession.insert("dao.TaskDao.insert", record);
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
    public int insertSelective(Task record) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            sqlSession.delete("dao.TaskDao.insertSelective", record);
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
    public Task selectByPrimaryKey(Integer taskId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Task record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Task record) {
        return 0;
    }

    @Override
    public List<Task> selectAllFromTask(Integer userid) {
        List<Task> list = null;
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            list = sqlSession.selectList("dao.TaskDao.selectAllFromTask", userid);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return list;
    }

    @Override
    public List<Task> selectAllToTask(Integer userid) {
        List<Task> list = null;
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        try {
            list = sqlSession.selectList("dao.TaskDao.selectAllToTask", userid);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return list;
    }
}
