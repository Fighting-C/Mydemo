package servlet.shareIndexServlet;

import com.alibaba.fastjson.JSONObject;
import entity.ShareIndex;
import service.shareIndexService;
import entity.Result;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @PackageName:servlet.shareIndexServlet
 * @Date:2022/4/2514:00
 * {
 *   "name": "产品"
 * }
 **/
@WebServlet({"/getOwnShare"})
public class getShareIndexServlet extends HttpServlet {
    private Result result = new Result();
    private JSONObject jsonObject = new JSONObject();
    private shareIndexService shareInexService = new shareIndexService();
    private List<ShareIndex> list = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String proid = req.getParameter("proid");
        list = shareInexService.selectByProId(Integer.parseInt(proid));
        result.setData(list);
        jsonObject.put("result", result);
        resp.getWriter().print(jsonObject);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
