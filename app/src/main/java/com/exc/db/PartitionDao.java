package com.exc.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.exc.api.vo.PartitionFindlistVo;
import com.exc.api.vo.PartitionQueryVo;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;


@Dao
public interface PartitionDao {

    @Insert(onConflict = REPLACE)
    void insert(PartitionQueryVo vo);

    @Insert(onConflict = REPLACE)
    void insert(List<PartitionQueryVo> vos);

    @Query("delete from partition where id = :id")
    void deleteById(int id);

    @Query("delete from partition")
    void deleteAll();

    @Update
    void update(PartitionQueryVo vo);

    @Query("select * from Partition order by id")
    List<PartitionQueryVo> query();

    //根据分区名称查出该分区下的ID
    @Query("select * from partition where name = :name order by name")
    List<PartitionQueryVo> namequery(String name);
}
