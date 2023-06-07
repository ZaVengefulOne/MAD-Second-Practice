package com.example.mawfd.data.datasource;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.example.mawfd.data.database.AccountsDataBase;
import com.example.mawfd.data.database.dao.AccountsDao;
import com.example.mawfd.data.database.entity.Account;
import com.example.mawfd.data.workers.UserDataWorker;
import com.example.mawfd.data.models.LoginAdministrator;
import com.example.mawfd.data.models.LoginUser;
import java.util.ArrayList;
import java.util.List;

public class AccountsDataSource {
    private final Context context;
    private final WorkManager workManager;

    List<Account> accounts = new ArrayList<>();

    public AccountsDataSource(Context context) {
        this.context = context;
        workManager = WorkManager.getInstance(context);
    }

    private Data createInputData(String login){
        Data.Builder Databuilder = new Data.Builder();
        Databuilder.putString(UserDataWorker.KEY_LOG, login);
        return Databuilder.build();
    }


    public boolean checkLoginUserValid(LoginUser loginUser, boolean allowed){
        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(UserDataWorker.class)
                .setInputData(createInputData(loginUser.getLogin())).build();
        workManager.enqueue(workRequest);
        return loginUser.getLogin().equals("Vengeful") &&
                loginUser.getPassword().equals("123456") || loginUser.getLogin().equals("Nakarat") &&
                loginUser.getPassword().equals("Tarakan") || loginUser.getLogin().equals("Korpalo1337") &&
                loginUser.getPassword().equals("ilovearabic") ;
    }


    public boolean checkAdminUserValid(LoginAdministrator loginAdministrator, boolean allowed){
        return loginAdministrator.getAdmlogin().equals("admin") &&
                loginAdministrator.getPasskey().equals("admin");
    }

    public LiveData<Account> getAccount(int position) {
        AccountsDataBase db = AccountsDataBase.getDatabase(context);
        AccountsDao accountsDao = db.accountsDao();
        MutableLiveData<Account> liveData = new MutableLiveData<>();
        LiveData<Account> doctorLiveData = accountsDao.getItem(position + 1);
        return liveData;
    }
}