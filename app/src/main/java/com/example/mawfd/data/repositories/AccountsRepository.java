package com.example.mawfd.data.repositories;

import android.content.Context;

import com.example.mawfd.data.protocols.AccountsProtocol;
import com.example.mawfd.data.datasource.AccountsDataSource;
import com.example.mawfd.data.models.LoginAdministrator;
import com.example.mawfd.data.models.LoginUser;

public class AccountsRepository implements AccountsProtocol {
    private final Context context;
    private final AccountsDataSource dataSource;

    public AccountsRepository(Context context){
        this.context = context;
        dataSource = new AccountsDataSource(context);
    }
    @Override
    public boolean adminLogin(LoginAdministrator loginAdministrator, boolean allowed) {
        return dataSource.checkAdminUserValid(loginAdministrator, allowed);
    }

    @Override
    public boolean userLogin(LoginUser loginUser) {
        return dataSource.checkLoginUserValid(loginUser);
    }

}
