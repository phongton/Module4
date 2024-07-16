package com.codegym.b1ss3.service.impl;

import com.codegym.b1ss3.model.EmailSetting;
import com.codegym.b1ss3.repository.IRepository;
import com.codegym.b1ss3.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services implements IService {
    @Autowired
    private IRepository repo;
    @Override
    public void save(EmailSetting emailSetting) {
        repo.save(emailSetting);
    }


}
