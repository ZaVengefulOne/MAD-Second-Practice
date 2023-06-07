package com.example.mawfd.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mawfd.data.database.dao.AccountsDao;
import com.example.mawfd.data.database.entity.Account;

@Database(entities = {Account.class}, version = 1, exportSchema = false)
public abstract class AccountsDataBase extends RoomDatabase {
    private static volatile AccountsDataBase INSTANCE;

    public abstract AccountsDao accountsDao();

    public static AccountsDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AccountsDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AccountsDataBase.class, "accounts_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}