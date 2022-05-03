package servlet.otherServlet;

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
import java.util.HashMap;
import java.util.List;

/**
 * @PackageName:servlet
 * @Date:2022/4/2020:44
 **/
@WebServlet("/gettable")
public class getMainTable extends HttpServlet {
    private JSONObject jsonObject = new JSONObject();
    private proService proService = new proService();
    private shareIndexService shareIndexService = new shareIndexService();
    private List<Production> list = null;
    private Result result = new Result();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int manageMoney = proService.allManageMoney();
        int proNumber = proService.SelectAllPro().size();
        double nowMoney = 0;
        int upPro = 0;
        int downPro = 0;
        int  otherMoney = manageMoney;
        List<ShareIndex> list2 = shareIndexService.selectAll();
        for (ShareIndex shareIndex : list2) {
            otherMoney -= shareIndex.getShareManage();
        }
        list = proService.SelectAllPro();
        for (Production production : list) {

            if (production.getProStatus().equals("已结算")) {
                nowMoney += (production.getProNowGet().doubleValue() * production.getProManage());
            }
            if (production.getProNowGet().doubleValue() < 0.0) {
                downPro++;
            }else {
                upPro++;
            }
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("manageMoney", manageMoney);
        map.put("proNumber", proNumber);
        map.put("nowMoney",(int)Math.round(nowMoney));
        map.put("upPro", upPro);
        map.put("downPro", downPro);
        map.put("otherMoney", otherMoney);

        result.setData(map);
        jsonObject.put("result", result);
        resp.getWriter().print(jsonObject);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
