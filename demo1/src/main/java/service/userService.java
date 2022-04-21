package service;

import dao.UserDao;
import dao.daoImp.UserDaoImp;
import entity.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;

/**
 * @PackageName:service
 * @Date:2022/3/812:05
 **/
public class userService {
    private UserDao userDao = new UserDaoImp();
    private User index = null;


    /**
     * 删除User
     */
    public int deleteByPrimaryKey(Integer userId) {
        return userDao.deleteByPrimaryKey(userId);
    }

    /**
     * 修改User
     */
    public int updateUser(User user) {
        return userDao.updateByPrimaryKeySelective(user);
    }
    /**
     * 新增User
     */
    public int insertUser(User user) {
        return userDao.insertSelective(user);
    }

    /**
      *登录处理 返回true为成功
     **/
    public int Login(User user) {
        if (user.getUserPassword() == null || user.getName() == null) {
            return -1;
        }
        index = userDao.selectByUserNumber(user.getName());
        String pwd1 =user.getUserPassword();
        String pwd2 = DigestUtils.md5Hex(index.getUserPassword());
        if (index == null) {
            return -1;
        } else if (pwd2.equals(pwd1)) {
            return index.getUserId();
        } else {
            return -1;
        }
    }

    /**
     * 通过user_id获取user信息
     */

    public User GetUserInfo(User user) {
        index = userDao.selectByPrimaryKey(user.getUserId());
        return index;
    }


    /**
     * 获取全部User信息
     *
     */
    public List<User> getAllUser() {
        return userDao.selectAllUsers();
    }

    public User selectByUserid(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }
}
