package service;

import dao.TaskDao;
import dao.daoImp.TaskDaoImp;
import entity.Task;

import java.util.List;

/**
 * @PackageName:service
 * @Date:2022/4/1516:52
 **/
public class taskService {
    private TaskDao taskDao = new  TaskDaoImp();
    private Task task = null;

    public List<Task> selectAllFromTask(Integer userid) {
        return taskDao.selectAllFromTask(userid);
    }

    public List<Task> selectAllToTask(Integer userid){
        return taskDao.selectAllToTask(userid);
    }

    public int  insertSelective(Task record){
        return taskDao.insertSelective(record);
    }
    public int deleteByPrimaryKey(Integer taskId) {
        return taskDao.deleteByPrimaryKey(taskId);
    }

}
