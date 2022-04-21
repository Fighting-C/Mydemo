package servlet.userServlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.IOUtils;
import com.sun.javafx.sg.prism.web.NGWebView;
import entity.Result;
import entity.User;
import service.userService;
import utils.decode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @PackageName:servlet
 * @Date:2022/3/915:01
 * MTExMTEx
 **/
@WebServlet("/login")
public class loginServlet extends HttpServlet {
    userService userService = new userService();
    User user = null;
    Result result = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject jsonObject = null;
        String username = "";

        String password = "";
        try {
            InputStreamReader reader=new InputStreamReader(req.getInputStream());
            BufferedReader buffer=new BufferedReader(reader);
            String data=buffer.readLine();
            jsonObject = JSON.parseObject(data);
            username = jsonObject.getString("username");
            password = jsonObject.getString("password");
            username = URLDecoder.decode(username, "UTF-8");
            user = new User(username, password);
            jsonObject.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
        result = new Result();
        int flag = userService.Login(user);
        if (flag != -1) {
            System.out.println(flag);
            result.setToken(String.valueOf(flag));
        } else {
            System.out.println("no user");
            result.setCode(50008);
            result.setToken("");
        }

        jsonObject.put("result", result);

        resp.getWriter().print(jsonObject);


    }
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{

            this.doGet(req, resp);

        }
}


