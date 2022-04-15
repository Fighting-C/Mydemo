package dao;

import entity.User;
import entity.UserIndex;

public interface UserIndexDao {
    int insert(UserIndex record);

    int insertSelective(UserIndex record);

    int updateSelective(UserIndex record);

    UserIndex selectUserIndexById(User record);
}