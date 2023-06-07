package com.example.mawfd.data.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "accounts_table")
public class Account {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    public Integer uid;
    private final String login;
    private final String password;

    private final boolean isAdmin;

    public Account(String login, String password, boolean isAdmin){
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;

    }
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean getIsAdmin() { return isAdmin; }
}