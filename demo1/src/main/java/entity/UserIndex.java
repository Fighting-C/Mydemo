package entity;

import java.io.Serializable;

/**
 * user_index
 * @author 
 */
public class UserIndex implements Serializable {
    private Integer userId;

    private String userType;

    /**
     * 用户权限标识
     */
    private Integer userIndex;

    @Override
    public String toString() {
        return "UserIndex{" +
                "userId=" + userId +
                ", userType='" + userType + '\'' +
                ", userIndex=" + userIndex +
                '}';
    }

    public UserIndex(Integer userId, String userType, Integer userIndex) {
        this.userId = userId;
        this.userType = userType;
        this.userIndex = userIndex;
    }

    public UserIndex() {
    }

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getUserIndex() {
        return userIndex;
    }

    public void setUserIndex(Integer userIndex) {
        this.userIndex = userIndex;
    }
}