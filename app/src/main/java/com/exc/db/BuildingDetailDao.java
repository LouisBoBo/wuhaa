package com.exc.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.exc.api.vo.ListBuildingVo;
import com.exc.api.vo.PartitionFindlistVo;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface BuildingDetailDao {
    @Insert(onConflict = REPLACE)
    void insert(ListBuildingVo.BuildingListBean vo);

    @Insert(onConflict = REPLACE)
    void insert(List<ListBuildingVo.BuildingListBean> vos);

    //返回所有建筑
    @Query("select * from buildingDetail order by id")
    List<ListBuildingVo.BuildingListBean> query();
}
