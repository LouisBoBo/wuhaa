package com.exc.wuh.DB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.exc.wuh.Dao.UserDao;
import com.exc.wuh.bean.User;
//数据库创建
@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class DB extends RoomDatabase {
    private static final String DB_NAME = "UserDatabase.db";
    private static volatile DB instance;

    public static synchronized DB getInstance(Context context){
        if(instance == null){
            instance = create(context);
        }
        return instance;
    }

    private static DB create(final Context context){
        return Room.databaseBuilder(
                context,
                DB.class,
                DB_NAME).build();
    }

    public abstract UserDao getUserDao();
}
