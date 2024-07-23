package com.codegym.formdk.service.impl;

import com.codegym.formdk.model.User;
import com.codegym.formdk.repository.IUserRepository;
import com.codegym.formdk.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
@Autowired
IUserRepository userRepository;
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
