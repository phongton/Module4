package com.codegym.th2ss3.repository;

import com.codegym.th2ss3.model.Login;
import com.codegym.th2ss3.model.User;

import java.util.List;

public interface IRepo {
    User checkLogin(Login login);
}
