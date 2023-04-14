package com.example.mawfd.data.datasource;

import android.content.Context;

import com.example.mawfd.data.models.LoginAdministrator;
import com.example.mawfd.data.models.LoginUser;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class AccountsDataSource {
    private final Context context;

    public AccountsDataSource(Context context) {
        this.context = context;
    }

    public boolean checkLoginUserValid(LoginUser loginUser){
        String filename = "Phone";
        String fileContents = loginUser.getLogin();
        File dir = context.getFilesDir();
        File file_phone = new File(dir, filename);
        try {
            FileOutputStream fos = new FileOutputStream(file_phone);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(fileContents);
            writer.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return !loginUser.getLogin().equals("") &&
                !loginUser.getPassword().equals("");
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