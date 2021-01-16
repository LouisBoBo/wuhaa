package com.exc.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.exc.api.vo.PartitionFindlistVo;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface BuildingDao {

    @Insert(onConflict = REPLACE)
    void insert(PartitionFindlistVo.ListBean vo);

    @Insert(onConflict = REPLACE)
    void insert(List<PartitionFindlistVo.ListBean> vos);

    @Query("delete from building where id = :id")
    void deleteById(int id);
    @Query("delete from building")
    void deleteAll();

    //返回所有建筑
    @Query("select * from building order by id")
    List<PartitionFindlistVo.ListBean> query();

    //根据分区ID查出该分区下的建筑
    @Query("select * from building where partitionId = :partitionId order by id")
    List<PartitionFindlistVo.ListBean> query(int partitionId);

    //建筑模糊查询
    @Query("select * from building where name like '%' || :content || '%' order by id")
    List<PartitionFindlistVo.ListBean> query(String content);
}
