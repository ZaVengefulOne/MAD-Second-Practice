package com.example.mawfd.ui.stateholder.viewModels;

import androidx.lifecycle.ViewModel;

import com.example.mawfd.data.models.LoginAdministrator;
import com.example.mawfd.data.repositories.AccountsRepository;

public class AdminEntranceViewModel extends ViewModel {

    private final AccountsRepository repository = new AccountsRepository();

    public boolean loginAccount(String login, String password) {
        LoginAdministrator administrator = new LoginAdministrator(login, password);
        return repository.adminLogin(administrator);
    }

}