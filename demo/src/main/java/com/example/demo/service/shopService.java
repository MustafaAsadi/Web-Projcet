package com.example.demo.service;

import com.example.demo.classes.customer;
import com.example.demo.classes.employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class shopService {

    private final com.example.demo.repositories.customerRepository customerRepository;

    private final com.example.demo.repositories.employeeRepository employeeRepository;

    public shopService(com.example.demo.repositories.customerRepository customerRepository, com.example.demo.repositories.employeeRepository employeeRepository) {
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
    }



    public List<customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public customer registerCustomer(customer customer) {
        return customerRepository.save(customer);
    }

    public employee registerEmployee(employee employee) {
        return employeeRepository.save(employee);
    }


    public Optional<customer> findCustomerByUsername(customer customer) {
        Optional<customer> username = customerRepository.searchByUsername(customer.getUsername());

        return username;
    }

    public Optional<customer> findCustomerByPassword(customer customer) {
        Optional<customer> password = customerRepository.searchByPassword(customer.getPassword());

        return password;
    }

    public customer getCustomerInfo(customer customer) {
        return customerRepository.searchForUser(customer.getUsername());
    }

    public Optional<employee> findEmployeeByUsername(employee employee) {
        Optional<employee> username = employeeRepository.searchByUsername(employee.getUsername());

        return username;
    }

    public Optional<employee> findEmployeeByPassword(employee employee) {
        Optional<employee> password = employeeRepository.searchByPassword(employee.getPassword());
        return password;
    }


    public employee getEmployeeInfo(employee employee) {
        return employeeRepository.searchForUser(employee.getUsername());
    }


}
