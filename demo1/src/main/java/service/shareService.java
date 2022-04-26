package service;

import dao.daoImp.ShareDaoImp;
import entity.Share;

import java.util.List;

/**
 * @PackageName:service
 * @Date:2022/4/2513:28
 **/
public class shareService {
    private ShareDaoImp shareDaoImp = new ShareDaoImp();
    private List<Share> list = null;
    private Share share = null;

    public List<Share> getAllShare() {
        return shareDaoImp.getAllShare();
    }
    public List<Share> selectByName(String name) {
        return shareDaoImp.selectByName("%"+name+"%");
    }
    public Share selectByPrimaryKey(Integer shareId) {
        return shareDaoImp.selectByPrimaryKey(shareId);
    }
}
