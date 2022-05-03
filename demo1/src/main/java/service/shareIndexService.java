package service;

import dao.ShareIndexDao;
import dao.daoImp.shareIndexDaoImp;
import entity.ShareIndex;

import java.util.List;

/**
 * @PackageName:service
 * @Date:2022/4/2513:58
 **/
public class shareIndexService {
    private ShareIndexDao shareIndexDao = new shareIndexDaoImp();

    public int insertSelective(ShareIndex record) {
        return shareIndexDao.insertselective(record);
    }

    public List<ShareIndex> selectByProId(Integer proid) {
        return shareIndexDao.selectByProId(proid);
    }
    public int updateByPrimaryKeySelective(ShareIndex record) {
        return shareIndexDao.updateByPrimaryKeySelective(record);

    }
    public int deleteByPrimaryKey(Integer indexId) {
        return shareIndexDao.deleteByPrimaryKey(indexId);
    }

    public List<ShareIndex> selectByName(String name) {
        return shareIndexDao.selectByName("%"+name+"%");
    }

    public List<ShareIndex> selectAll() {
        return shareIndexDao.selectAll();
    }
    }
