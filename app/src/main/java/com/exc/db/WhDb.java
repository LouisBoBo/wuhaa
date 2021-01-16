package com.exc.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.exc.api.vo.ListBuildingVo;
import com.exc.api.vo.PartitionFindlistVo;
import com.exc.api.vo.PartitionQueryVo;

@Database(entities = {PartitionQueryVo.class, PartitionFindlistVo.ListBean.class, ListBuildingVo.BuildingListBean.class}, version = 1, exportSchema = false)
public abstract class WhDb extends RoomDatabase {
    private static WhDb instance;

    public synchronized static WhDb getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, WhDb.class, "wh_db").allowMainThreadQueries().build();
        }
        return instance;
    }

    public abstract PartitionDao getPartitionDao();

    public abstract BuildingDao getBuildingDao();

    public abstract BuildingDetailDao getBuildingDetailDao();
}
