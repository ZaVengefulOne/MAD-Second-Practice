package com.example.mawfd.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mawfd.data.database.entity.Account;

import java.util.List;

@Dao
public interface AccountsDao {
    @Query("SELECT * FROM accounts_table")
    LiveData<List<Account>> getAccounts();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Account account);
    @Query("SELECT * FROM accounts_table WHERE :id LIKE id")
    LiveData<Account> getItem(int id);
}
