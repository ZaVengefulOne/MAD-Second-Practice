package com.example.mawfd.ui.stateholder.viewModels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.mawfd.data.models.LoginAdministrator;
import com.example.mawfd.data.models.LoginUser;
import com.example.mawfd.data.repositories.AccountsRepository;

public class EntranceViewModel extends AndroidViewModel {
    private final AccountsRepository accountsRepository = new AccountsRepository(getApplication());

    public EntranceViewModel(@NonNull Application application) {
        super(application);
    }

    public boolean loginAccount(String login, String password, boolean allowed){
        LoginUser loginUser = new LoginUser(login, password);
        return accountsRepository.userLogin(loginUser, allowed);
    }
    public boolean AdminAccount(String login, String password, boolean allowed){
        LoginAdministrator loginAdministrator = new LoginAdministrator(login, password);
        return accountsRepository.adminLogin(loginAdministrator, allowed);
    }
}
