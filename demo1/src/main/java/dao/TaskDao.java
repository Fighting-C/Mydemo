package dao;

import entity.Task;

import java.util.List;

public interface TaskDao {
    int deleteByPrimaryKey(Integer taskId);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Integer taskId);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    List<Task> selectAllFromTask(Integer userid);

    List<Task> selectAllToTask(Integer userid);
}