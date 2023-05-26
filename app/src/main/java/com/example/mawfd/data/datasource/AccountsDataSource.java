package com.example.mawfd.data.datasource;

import android.content.Context;

import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.example.mawfd.data.workers.UserDataWorker;
import com.example.mawfd.data.models.LoginAdministrator;
import com.example.mawfd.data.models.LoginUser;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class AccountsDataSource {
    private final Context context;
    private final WorkManager workManager;

    public AccountsDataSource(Context context) {
        this.context = context;
        workManager = WorkManager.getInstance(context);
    }

    private Data createInputData(String login){
        Data.Builder Databuilder = new Data.Builder();
        Databuilder.putString(UserDataWorker.KEY_LOG, login);
        return Databuilder.build();
    }


    public boolean checkLoginUserValid(LoginUser loginUser){
//        String filename = "Login";
//        String fileContents = loginUser.getLogin();
//        File dir = context.getFilesDir();
//        File file_phone = new File(dir, filename);
//        try {
//            FileOutputStream fos = new FileOutputStream(file_phone);
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
//            writer.write(fileContents);
//            writer.close();
//            fos.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return !loginUser.getLogin().equals("") &&
//                !loginUser.getPassword().equals("");
        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(UserDataWorker.class)
                .setInputData(createInputData(loginUser.getLogin())).build();
        workManager.enqueue(workRequest);
        return loginUser.getLogin().equals("") &&
                loginUser.getPassword().equals("");
    }


    public boolean checkAdminUserValid(LoginAdministrator loginAdministrator, boolean allowed){
        if (allowed) {
            String filename = "Key";
            String fileContents = loginAdministrator.getPasskey();
            File file_key = new File("/storage/emulated/0/Android/data", filename);
            try {
                FileOutputStream fos = new FileOutputStream(file_key);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
                writer.write(fileContents);
                writer.close();
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return !loginAdministrator.getAdmlogin().equals("") &&
                !loginAdministrator.getPasskey().equals("");
    }
}