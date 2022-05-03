package servlet.shareIndexServlet;

import com.alibaba.fastjson.JSONObject;
import entity.Production;
import entity.Result;
import entity.ShareIndex;
import service.proService;
import service.shareIndexService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @PackageName:servlet.shareIndexServlet
 * @Date:2022/4/2521:07
 **/
@WebServlet("/deleteshare")
public class deleteShareIndex extends HttpServlet {
    private Result result = new Result();
    private JSONObject jsonObject = new JSONObject();
    private shareIndexService shareIndexService = new shareIndexService();
    private proService proService = new proService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer indexId = Integer.parseInt(req.getParameter("indexId"));
        String proid = req.getParameter("proid");
        Production production = proService.selectByPrimaryKey(Integer.parseInt(proid));
        int flag = shareIndexService.deleteByPrimaryKey(indexId);
        if (flag == 0) {
            result.setCode(40000);
        }else {
            result.setCode(20000);
        }
        List list = shareIndexService.selectByProId(Integer.parseInt(proid));
        System.out.println(list);
        if (list.size() == 0) {
            production.setProNowGet(BigDecimal.ZERO.setScale(2, 2));
            production.setProId(Integer.parseInt(proid));
        } else {
            production.setProNowGet(new BigDecimal(Math.random() * (2) + (-1)).setScale(2, 2));
            production.setProId(Integer.parseInt(proid));
        }

        proService.updateByPrimaryKeySelective(production);

        jsonObject.put("result", result);
        resp.getWriter().print(jsonObject);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
