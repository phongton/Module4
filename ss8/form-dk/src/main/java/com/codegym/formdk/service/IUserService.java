package com.codegym.formdk.service;

import com.codegym.formdk.model.User;

import java.util.List;

public interface IUserService {
    List<User> getUsers();
    User saveUser(User user);
}
