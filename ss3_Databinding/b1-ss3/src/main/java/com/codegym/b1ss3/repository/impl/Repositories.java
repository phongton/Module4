package com.codegym.b1ss3.repository.impl;

import com.codegym.b1ss3.model.EmailSetting;
import com.codegym.b1ss3.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Repositories implements IRepository {
    private static EmailSetting email;

    private static List<EmailSetting> emailSettings = new ArrayList<>();
    @Override
    public void save(EmailSetting emailSetting) {
        emailSettings.add(emailSetting);

    }



}
