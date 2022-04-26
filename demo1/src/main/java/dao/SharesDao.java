package dao;

import entity.Share;

import java.util.List;

public interface SharesDao {
    int deleteByPrimaryKey(Integer shareId);

    int insert(Share record);

    int insertSelective(Share record);

    Share selectByPrimaryKey(Integer shareId);

    int updateByPrimaryKeySelective(Share record);

    int updateByPrimaryKey(Share record);

    List<Share> getAllShare();

    List<Share> selectByName(String name);
}