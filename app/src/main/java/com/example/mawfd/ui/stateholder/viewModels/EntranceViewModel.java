package com.example.mawfd.ui.stateholder.viewModels;

import androidx.lifecycle.ViewModel;

import com.example.mawfd.data.models.LoginUser;
import com.example.mawfd.data.repositories.AccountsRepository;

public class EntranceViewModel extends ViewModel {
    private final AccountsRepository accountsRepository = new AccountsRepository();

    public boolean loginAccount(String login, String password){
        LoginUser loginUser = new LoginUser(login, password);
        return accountsRepository.userLogin(loginUser);
    }
}
