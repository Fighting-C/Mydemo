package servlet.userServlet;

import com.alibaba.fastjson.JSONObject;
import entity.Result;
import entity.User;
import service.userIndexService;
import service.userService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.Line;
import java.io.IOException;
import java.util.List;

/**
 * @PackageName:servlet
 * @Date:2022/3/2121:33
 **/


/**
 * 'admin-token': {
 * roles: ['admin'],
 * introduction: 'I am a super administrator',
 * avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
 * name: 'Super Admin'
 * },
 */
@WebServlet(urlPatterns = {"/info", "/allUser"})
public class getUserServlet extends HttpServlet {
    userService userService = new userService();
    userIndexService userIndexService = new userIndexService();
    Result result = new Result();
    User user = null;
    List<User> list = null;
    JSONObject jsonObject = new JSONObject();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/info")) {
                String userid = req.getParameter("token");
            user = userService.selectByUserid(Integer.parseInt(userid));
                String role = user.getRoles();
                user.setRoles(role);
            result.setData(user);

        } else if (path.equals("/allUser")) {
            list = userService.getAllUser();
            System.out.println(list);
            result.setData(list);
        }

        jsonObject.put("result", result);
        resp.getWriter().print(jsonObject);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
