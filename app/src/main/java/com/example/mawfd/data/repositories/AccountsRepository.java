package com.example.mawfd.data.repositories;

import com.example.mawfd.data.protocols.AccountsProtocol;
import com.example.mawfd.data.datasource.AccountsDataSource;
import com.example.mawfd.data.models.LoginAdministrator;
import com.example.mawfd.data.models.LoginUser;

public class AccountsRepository implements AccountsProtocol {
    private final AccountsDataSource dataSource = new AccountsDataSource();

    @Override
    public boolean adminLogin(LoginAdministrator loginAdministrator) {
        return dataSource.checkAdminUserValid(loginAdministrator);
    }

    @Override
    public boolean userLogin(LoginUser loginUser) {
        return dataSource.checkLoginUserValid(loginUser);
    }

}
