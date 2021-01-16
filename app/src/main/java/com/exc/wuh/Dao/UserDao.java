package com.exc.wuh.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.exc.wuh.bean.User;

import java.util.List;
import java.util.jar.Attributes;

//数据库表操作
@Dao
public interface UserDao {
    @Query("SELECT * FROM USER")
    List<User> getAllUsers();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int... userIds);

    @Query("SELECT * FROM user WHERE name LIKE '%' || :name || '%' ")
    List<User> getUserfromname(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User... users);

    @Update
    void update(User... users);

    @Delete
    void delete(User... users);

    @Query("DELETE FROM USER")
    void deleteAll();
}
