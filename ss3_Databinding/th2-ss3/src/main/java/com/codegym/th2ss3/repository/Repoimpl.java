package com.codegym.th2ss3.repository;

import com.codegym.th2ss3.model.Login;
import com.codegym.th2ss3.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static javax.management.Query.or;
@Repository
public class Repoimpl implements IRepo{
    private static List<User> users;
    static {
        users = new ArrayList<>();
        users.add(new User("john", "123456", "John", "john@codegym.vn", 18));
        users.add(new User("bill", "123456", "Bill", "bill@codegym.vn", 20));
        users.add(new User("mike", "123456", "Mike", "mike@codegym.vn", 22));
    }

    @Override
    public  User checkLogin(Login login) {
        for (User user : users) {
            if (user.getAccount().equals(login.getAccount())
                    && user.getPassword().equals(login.getPassword())) {
                return user;
            }
        }
        return null;
    }   

}
