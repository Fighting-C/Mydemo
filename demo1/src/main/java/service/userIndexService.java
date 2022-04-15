package service;

import dao.UserIndexDao;
import dao.daoImp.UserIndexDaoImp;
import entity.User;
import entity.UserIndex;

/**
 * @PackageName:service
 * @Date:2022/4/123:58
 **/
public class userIndexService {
    private UserIndexDao userIndexDao = new UserIndexDaoImp();
    private UserIndex userIndex = null;

    public String SelectByUserId(User record) {
        String index = "";
        try {
            index = userIndexDao.selectUserIndexById(record).getUserType();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (index.contains("1")) {
            return "admin";
        }else {
            return "Editor";
        }
    }
    }

