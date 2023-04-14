package com.example.mawfd.ui.stateholder.viewModels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.mawfd.data.models.LoginUser;
import com.example.mawfd.data.repositories.AccountsRepository;

public class EntranceViewModel extends AndroidViewModel {
    private final AccountsRepository accountsRepository = new AccountsRepository(getApplication());

    public EntranceViewModel(@NonNull Application application) {
        super(application);
    }

    public boolean loginAccount(String login, String password){
        LoginUser loginUser = new LoginUser(login, password);
        return accountsRepository.userLogin(loginUser);
    }
}
