package com.example.mawfd.data.protocols;

import com.example.mawfd.data.models.LoginAdministrator;
import com.example.mawfd.data.models.LoginUser;

public interface AccountsProtocol {

    boolean adminLogin(LoginAdministrator loginAdministrator, boolean allowed);

    boolean userLogin(LoginUser loginUser, boolean allowed);

}