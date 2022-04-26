package servlet.otherServlet;

import com.alibaba.fastjson.JSONObject;
import entity.Production;
import entity.Result;
import service.proService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
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
    private List<Production> list = null;
    private Result result = new Result();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int manageMoney = proService.allManageMoney();
        int proNumber = proService.SelectAllPro().size();
        int nowMoney = 0;
        int upPro = 0;
        int downPro = 0;
        int  otherMoney = 1000000 - manageMoney;

        list = proService.SelectAllPro();
        for (Production production : list) {
            
            if (production.getProNowGet().doubleValue() < 0.0) {
                downPro++;
            }else {
                upPro++;
            }
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("manageMoney", manageMoney);
        map.put("proNumber", proNumber);
        map.put("nowMoney", nowMoney);
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
