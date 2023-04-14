package com.example.mawfd.ui.stateholder.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.mawfd.data.models.LoginAdministrator;
import com.example.mawfd.data.repositories.AccountsRepository;

public class AdminEntranceViewModel extends AndroidViewModel {

    private final AccountsRepository repository = new AccountsRepository(getApplication());

    public AdminEntranceViewModel(@NonNull Application application) {
        super(application);
    }

    public boolean loginAccount(String login, String password, boolean allowed) {
        LoginAdministrator administrator = new LoginAdministrator(login, password);
        return repository.adminLogin(administrator, allowed);
    }

}