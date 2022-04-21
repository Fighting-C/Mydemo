package Demo;

import entity.Task;
import org.junit.Test;
import service.taskService;

import java.util.List;

/**
 * @PackageName:Demo
 * @Date:2022/4/1710:55
 **/
public class test_task  {
    @Test
    public void test1() {
        taskService taskService = new taskService();
        List<Task> list = taskService.selectAllFromTask(2);
        System.out.println(list);
    }

    @Test
    public void test2() {
        taskService taskService = new taskService();
        List<Task> list = taskService.selectAllToTask("approver");
        System.out.println(list);
    }

    @Test
    public void test3() {
        taskService taskService = new taskService();
        Task task = new Task();
        task.setFromUserid(2);
        task.setToUsertype("admin");
        task.setProId(1);
        System.out.println(taskService.insertSelective(task));
    }
    @Test
    public void test4() {
        taskService taskService = new taskService();
        Task task = new Task();
        task.setTaskId(1);
        task.setTaskStatu("未通过");
        System.out.println(taskService.updateByPrimaryKeySelective(task));
    }
    @Test
    public void test5() {
        taskService taskService = new taskService();
        Task task = new Task();
        task.setTaskId(1);
        System.out.println(taskService.getTaskByTaskId(1));
    }
}
