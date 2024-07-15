package com.codegym.th2_ss1.service.iml;

import com.codegym.th2_ss1.model.Customer;
import com.codegym.th2_ss1.repository.Repository;
import com.codegym.th2_ss1.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private Repository repository;
    @Override
    public List<Customer> getCustomers() {
        return repository.getCustomers();
    }

    @Override
    public void updateCustomer(Customer customer) {
        repository.updateCustomer(customer);
    }

    @Override
    public Customer infoCustomer(int id) {
        return repository.infoCustomer(id);
    }
}
