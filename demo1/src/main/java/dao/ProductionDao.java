package dao;

import entity.Production;

import java.util.List;


public interface ProductionDao {
    int deleteByPrimaryKey(Integer proId);

    int insert(Production record);

    int insertSelective(Production record);

    Production selectByPrimaryKey(Integer proId);

    int updateByPrimaryKeySelective(Production record);

    int updateByPrimaryKey(Production record);

    public List<Production> selectAllPro();
}