package servlet.shareIndexServlet;

import com.alibaba.fastjson.JSONObject;
import entity.Result;
import entity.Share;
import entity.ShareIndex;
import service.shareIndexService;
import service.shareService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @PackageName:servlet.shareIndexServlet
 * @Date:2022/4/2514:20
 *
 **/
@WebServlet("/addOwnShare")
public class addShareIndex extends HttpServlet {
    private Result result = new Result();
    private JSONObject jsonObject = new JSONObject();
    private shareIndexService shareInexService = new shareIndexService();
    private List<ShareIndex> list = null;
    private shareService shareService = new shareService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shareid = req.getParameter("shareid");
        String proid = req.getParameter("proid");
        ShareIndex shareIndex = new ShareIndex();
        try {
            Share share = shareService.selectByPrimaryKey(Integer.parseInt(shareid));
            shareIndex.setProId(Integer.parseInt(proid));
            shareIndex.setShareId(Integer.parseInt(shareid));
            shareIndex.setShareName(share.getShareName());
            shareIndex.setShareNumber(share.getShareNumber());
            shareIndex.setSharePrice(share.getSharePrice());
            shareIndex.setShareType(share.getShareType());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int flag = shareInexService.insertSelective(shareIndex);
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
