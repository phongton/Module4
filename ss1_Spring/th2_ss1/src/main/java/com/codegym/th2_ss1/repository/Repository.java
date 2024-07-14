package com.codegym.th2_ss1.repository;

import com.codegym.th2_ss1.model.Customer;

import java.util.ArrayList;
import java.util.List;
@org.springframework.stereotype.Repository
public class Repository {
   private static  List<Customer> customers;
static {
    customers = new ArrayList<>();
    customers.add(new Customer(1, "Nguyen Khac Nhat", "nhat@codegym.vn", "Hà Nội"));
    customers.add(new Customer(2, "Dang Huy Hoa", "hoa.dang@codegym.vn", "Đà Nẵng"));
    customers.add(new Customer(3, "Le Thi Chau", "chau.le@codegym.vn", "Hà Nội"));
    customers.add(new Customer(4, "Nguyen Thuy Duong", "duong.nguyen@codegym.vn", "Sài Gòn"));
    customers.add(new Customer(5, "CodeGym", "codegym@codegym.vn", "Việt Nam"));
}
public List<Customer> getCustomers() {
    return customers;
}
public void updateCustomer(Customer customer) {
for (Customer c : customers) {
    if (c.getId() == customer.getId()) {
        c.setName(customer.getName());
        c.setEmail(customer.getEmail());
        c.setAddress(customer.getAddress());
        break;
    }
}
}

    public Customer infoCustomer(int id) {
    for (Customer c : customers) {
        if (c.getId() == id) {
            return c;
            
        }
    }
    return null;

    }
}

