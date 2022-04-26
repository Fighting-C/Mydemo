package servlet.shareIndexServlet;

import com.alibaba.fastjson.JSONObject;
import entity.Result;
import entity.ShareIndex;
import service.shareIndexService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @PackageName:servlet.shareIndexServlet
 * @Date:2022/4/2521:07
 **/
@WebServlet("/deleteshare")
public class deleteShareIndex extends HttpServlet {
    private Result result = new Result();
    private JSONObject jsonObject = new JSONObject();
    private shareIndexService shareIndexSercide = new shareIndexService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer indexId = Integer.parseInt(req.getParameter("indexId"));
        int flag = shareIndexSercide.deleteByPrimaryKey(indexId);
        if (flag == 0) {
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
