package servlet.shareServelt;


import com.alibaba.fastjson.JSONObject;
import entity.Result;
import entity.Share;
import service.shareService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

/**
 * @PackageName:servlet.shareServelt
 * @Date:2022/4/2513:23
 * {
 *   "shareid": 1,
 *   "money": "12312"
 * }
 **/
@WebServlet({"/getShareList","/searchList"})
public class getShareServlet extends HttpServlet {
    private Result result = new Result();
    private JSONObject jsonObject = new JSONObject();
    private shareService shareService = new shareService();
    private List<Share> list = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if("/getShareList".equals(path)){
            list = shareService.getAllShare();
        } else {
            String name = req.getParameter("name");
            name = URLDecoder.decode(name, "UTF-8");
            list = shareService.selectByName(name);
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
