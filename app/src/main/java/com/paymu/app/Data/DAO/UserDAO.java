package com.paymu.app.Data.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.paymu.app.Data.Model.UserEntity;

@Dao
public interface UserDAO {
    @Insert
    void Register (UserEntity user);

    @Query("SELECT * FROM UserEntity WHERE Email=(:mail) and Password=(:pass)")
    UserEntity login (String mail , String pass);

    @Query("SELECT * FROM UserEntity WHERE Email=(:user)")
    UserEntity recovery(String user);
}
