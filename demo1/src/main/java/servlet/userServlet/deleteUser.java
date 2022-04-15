package servlet.userServlet;

import com.alibaba.fastjson.JSONObject;
import entity.Result;
import service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @PackageName:servlet
 * @Date:2022/4/1421:42
 **/
@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
    Result result = new Result();
    userService userService = new userService();
    JSONObject jsonObject = new JSONObject();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = req.getParameter("id");
        int flag = userService.deleteByPrimaryKey(Integer.parseInt(userid));
        if (flag == 0) {
            result.setCode(40000);
        }
        jsonObject.put("result", result);
        resp.getWriter().print(jsonObject);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
