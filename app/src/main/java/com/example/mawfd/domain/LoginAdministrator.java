package com.example.mawfd.domain;

public class LoginAdministrator {
    private final String passkey;
    private final String admlogin;

    public LoginAdministrator(String passkey, String admlogin){
        this.passkey = passkey;
        this.admlogin = admlogin;
    }

    public String getPasskey() {
        return passkey;
    }

    public String getAdmlogin() {
        return admlogin;
    }
}
