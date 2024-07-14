package com.codegym.th2_ss1.service;

import com.codegym.th2_ss1.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getCustomers();
    void updateCustomer(Customer customer);
    Customer infoCustomer(int id);

}
