package servlet.proServlet;

/**
 * @PackageName:servlet.proServlet
 * @Date:2022/4/1511:49
 **/

import com.alibaba.fastjson.JSONObject;
import entity.Production;
import entity.Result;
import entity.Task;
import service.proService;
import service.taskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * {
 * "protype": "",
 * "proname": "11",
 * "probegintime": "2022-00-30",
 * "proendtime": "2022-00-01",
 * "lowmoney": "11",
 * "advice": 80,
 * "ways": 0,
 * "type": 0
 * }
 */

@WebServlet("/updatePro")
public class updatePro extends HttpServlet {
    private Production production = null;
    private proService proService = new proService();
    private JSONObject jsonObject = new JSONObject();
    private Result result = new Result();
    private taskService taskService = new taskService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String proname = req.getParameter("proname");
        proname = URLDecoder.decode(proname, "UTF-8");
        String protype = req.getParameter("protype");
        String probegintime = req.getParameter("probegintime");
        String proendtime = req.getParameter("proendtime");
        String lowmoney = req.getParameter("lowmoney");
        Integer advice = Integer.parseInt(req.getParameter("advice"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Integer fromid = Integer.parseInt(req.getParameter("userId"));
        Date betime = null;
        Date endtime = null;
        try {
            betime = format.parse(probegintime);
            endtime = format.parse(proendtime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        protype = getprotype(protype);
        System.out.println(protype);
        production = new Production(proname,protype,betime,endtime);
        production.setProCang(advice);
        production.setProManage(Integer.parseInt(lowmoney));
        production.setProStatus("正在审批中");
        int flag = proService.insertSelective(production);
        Task task = new Task();
        task.setTaskType("创建");
        task.setToUsertype("approver");
        task.setFromUserid(fromid);
        task.setTaskTime(new Date());
        List<Production> list = proService.SelectAllPro();
        task.setProId(list.get(list.size()-1).getProId());
        task.setTaskStatu("正在处理");
        taskService.insertSelective(task);
        result.setCode(20000);
        if (flag == 0) {
            result.setCode(40000);
        }
        jsonObject.put("result", result);
        resp.getWriter().print(jsonObject);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    private String getprotype(String index) {
        String type = "";
        switch (index) {
            case "0":
                type = "公募";
                break;
            case "1":
                type = "私募";
                break;
            case "2":
                type = "集合理财";
                break;
                default:
        }
        return type;
    }
}
