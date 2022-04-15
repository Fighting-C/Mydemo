package servlet.proServlet;

import com.alibaba.fastjson.JSONObject;
import dao.daoImp.ProductionDaoImp;
import entity.Production;
import entity.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @PackageName:servlet
 * @Date:2022/4/211:23
 **/
@WebServlet(urlPatterns = {"/getPro","/getAllPro"})
public class getProServlet extends HttpServlet {
    ProductionDaoImp productionDaoImp = new ProductionDaoImp();
    Production production = null;
    List<Production> list = null;
    JSONObject jsonObject = new JSONObject();
    Result result = new Result();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        System.out.println(path);
        if (path.equals("/getAllPro")) {
            list = productionDaoImp.selectAllPro();
            result.setData(list);

            jsonObject.put("result", result);
            System.out.println(list);
        }else {
            System.out.println(path);
        }
        resp.getWriter().print(jsonObject);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
