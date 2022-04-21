package servlet.userServlet;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.IOUtils;
import entity.Result;
import entity.User;
import service.userService;
import sun.nio.ch.IOUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Date;

/**
 * @PackageName:servlet
 * @Date:2022/4/1417:12
 **/

@WebServlet("/updateUser")
public class updateUser extends HttpServlet {
   private User user = null;
   private userService userService = new userService();
   private Result result = new Result();
   private JSONObject jsonObject = new JSONObject();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            String userid = req.getParameter("userId");
            String username = req.getParameter("name");
            username = URLDecoder.decode(username, "UTF-8");
            String pwd = req.getParameter("userPassword");
            String roles = req.getParameter("roles");
            user = new User(username);
            if (!"".equals(pwd)) {
                user.setUserPassword(pwd);
            }
            if (roles!=null) {
                if (roles.equals("0")) {
                    roles = "admin";
                }else if (roles.equals("1")){
                    roles = "editor";
                }else{
                    roles = "approver";
                }
                user.setRoles(roles);
            }

            if (userid==null||userid.equals("")) {
                Date date = new Date();
                user.setTime(date);
                userService.insertUser(user);
            }else {
                user.setUserId(Integer.parseInt(userid));
                userService.updateUser(user);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            jsonObject.put("result", result);
            resp.getWriter().print(jsonObject);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
