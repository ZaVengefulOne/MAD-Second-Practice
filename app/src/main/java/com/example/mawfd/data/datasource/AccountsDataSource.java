package com.example.mawfd.data.datasource;
import com.example.mawfd.data.models.LoginUser;
import com.example.mawfd.data.models.LoginAdministrator;


public class AccountsDataSource {

    public boolean checkLoginUserValid(LoginUser loginUser){
        return loginUser.getLogin().equals("") && loginUser.getPassword().equals("");
    }

    public boolean checkAdminUserValid(LoginAdministrator loginAdministrator){
        return loginAdministrator.getAdmlogin().equals("vengeful") && loginAdministrator.getPasskey().equals("123");
    }
}