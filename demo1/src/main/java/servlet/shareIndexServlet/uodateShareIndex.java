package servlet.shareIndexServlet;

import com.alibaba.fastjson.JSONObject;
import entity.Result;
import entity.ShareIndex;
import jdk.nashorn.internal.ir.Flags;
import service.shareIndexService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import service.shareIndexService;

/**
 * @PackageName:servlet.shareIndexServlet
 * @Date:2022/4/2515:26
 **/
@WebServlet("/updateIndexShare")
public class uodateShareIndex extends HttpServlet {
    private Result result = new Result();
    private JSONObject jsonObject = new JSONObject();
    private shareIndexService shareIndexSercide = new shareIndexService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer indexId = Integer.parseInt(req.getParameter("indexId"));
        Integer money = Integer.parseInt(req.getParameter("money"));
        ShareIndex shareIndex = new ShareIndex();
        shareIndex.setIndexId(indexId);
        shareIndex.setShareManage(money);
        int flag = shareIndexSercide.updateByPrimaryKeySelective(shareIndex);
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
