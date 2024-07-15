package com.codegym.bt1ss2.service;

import com.codegym.bt1ss2.model.Condiment;
import com.codegym.bt1ss2.repository.IRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Services implements IService {
    @Autowired
    private IRepo repo;
    @Override
    public List<Condiment> listCondiments() {
        return repo.condimentList();
    }
}
