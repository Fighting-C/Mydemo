package servlet.taskServlet;

import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.bind.v2.model.core.ID;
import dao.TaskDao;
import entity.Production;
import entity.Result;
import entity.Task;
import service.proService;
import service.taskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @PackageName:servlet.taskServlet
 * @Date:2022/4/2022:43
 * {
 *   "taskId": 1
 * }
 **/
@WebServlet({"/unpass","/pass"})
public class updateTask  extends HttpServlet {
    private Task task = new Task();
    private Result result = new Result();
    private JSONObject jsonObject = new JSONObject();
    private taskService taskService = new taskService();
    private proService proService = new proService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskId = req.getParameter("taskId");
        String path = req.getServletPath();
        task.setTaskId(Integer.parseInt(taskId));
        int flag;
        Task task2 = taskService.getTaskByTaskId(Integer.parseInt(taskId));
        String type = task2.getTaskType();
        if ("/unpass".equals(path)) {
            task.setTaskStatu("未通过");
            if ("创建".equals(type)) {
                Production production = new Production();
                production.setProId(task2.getProId());
                production.setProStatus("未通过创建审核");
                proService.updateByPrimaryKeySelective(production);
            }
        }else {
            if ("分红".equals(type)) {
                Production production = new Production();
                production.setProId(task2.getProId());
                production.setProLasttime(new Date());
                proService.updateByPrimaryKeySelective(production);
            }else if ("结算".equals(type)){
                Production production = new Production();
                production.setProId(task2.getProId());
                production.setProStatus("已结算");
                proService.updateByPrimaryKeySelective(production);
            }else {
                Production production = new Production();
                production.setProId(task2.getProId());
                production.setProStatus("运营中");
                proService.updateByPrimaryKeySelective(production);
            }

            task.setTaskStatu("已通过");

        }
        flag = taskService.updateByPrimaryKeySelective(task);

        if (flag == -1) {
            result.setCode(40000);
        }

        jsonObject.put("result", result);
        resp.getWriter().print(jsonObject);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req, resp);
    }
}
