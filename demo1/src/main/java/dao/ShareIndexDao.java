package dao;

import entity.ShareIndex;

import java.util.List;

public interface ShareIndexDao {
    int deleteByPrimaryKey(Integer indexId);

    int insert(ShareIndex record);

    int insertselective(ShareIndex record);

    ShareIndex selectByPrimaryKey(Integer indexId);

    int updateByPrimaryKeySelective(ShareIndex record);

    int updateByPrimaryKey(ShareIndex record);

    List<ShareIndex> selectByProId(Integer proid);

    List<ShareIndex> selectByName(String name);

}