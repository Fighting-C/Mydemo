package servlet.taskServlet;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.NEW;
import entity.Result;
import entity.Task;
import service.taskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @PackageName:servlet.taskServlet
 * @Date:2022/4/1713:46 {
 * "userId": "2"
 * }
 **/
@WebServlet({"/getToTask", "/getFromTask"})
public class getTasksServlet extends HttpServlet {
    private List<Task> list = null;
    private taskService taskService = new taskService();
    private JSONObject jsonObject = new JSONObject();
    private Result result = new Result();
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        String userId = req.getParameter("id");
        if ("/getToTask".equals(path)) {
            list = taskService.selectAllToTask(Integer.parseInt(userId));
        }else{
            list = taskService.selectAllFromTask(Integer.parseInt(userId));
        }
        result.setData(list);
        jsonObject.put("result", result);
        resp.getWriter().print(jsonObject);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
