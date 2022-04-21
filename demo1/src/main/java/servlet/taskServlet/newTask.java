package servlet.taskServlet;

import com.alibaba.fastjson.JSONObject;
import entity.Result;
import entity.Task;
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
 * @Date:2022/4/2021:23 {
 * "proId": 1,
 * "userId": "2"
 * }
 **/
@WebServlet({"/fenHong","/jieSuan"})
public class newTask extends HttpServlet {
    private Task task = new Task();
    private JSONObject jsonObject = new JSONObject();
    private Result result = new Result();
    private taskService taskService = new taskService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        int flag = -1;
        String userId = req.getParameter("userId");
        String proId = req.getParameter("proId");
        task.setFromUserid(Integer.parseInt(userId));
        String touserType = "approver";
        task.setToUsertype(touserType);
        task.setProId(Integer.parseInt(proId));
        task.setTaskTime(new Date());
        task.setTaskStatu("正在处理");
        if ("/fenHong".equals(path)){
            task.setTaskType("分红");

        }else {
            task.setTaskType("结算");
        }
        flag = taskService.insertSelective(task);
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
