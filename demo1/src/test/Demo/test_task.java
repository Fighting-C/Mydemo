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
        List<Task> list = taskService.selectAllToTask(2);
        System.out.println(list);
    }

    @Test
    public void test3() {
        taskService taskService = new taskService();
        Task task = new Task();
        task.setFromUserid(2);
        task.setToUserid(4);
        task.setProId(1);
        System.out.println(taskService.insertSelective(task));
    }
}
