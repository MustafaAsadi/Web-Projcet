package com.example.demo.service;

import com.example.demo.classes.customer;
import com.example.demo.classes.employee;
import jakarta.persistence.criteria.CriteriaBuilder;
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


    public Optional<customer> findCustomerByEmail(customer customer) {
        Optional<customer> username = customerRepository.searchByEmail(customer.getEmail());

        return username;
    }

    public Optional<customer> findCustomerByPassword(customer customer) {
        Optional<customer> password = customerRepository.searchByPassword(customer.getPassword());

        return password;
    }

    public customer getCustomerInfo(customer customer) {
        return customerRepository.searchForUser(customer.getEmail());
    }

    public Optional<employee> findEmployeeByEmail(employee employee) {
        Optional<employee> username = employeeRepository.searchByEmail(employee.getEmail());

        return username;
    }

    public Optional<employee> findEmployeeByPassword(employee employee) {
        Optional<employee> password = employeeRepository.searchByPassword(employee.getPassword());
        return password;
    }


    public employee getEmployeeInfo(employee employee) {
        return employeeRepository.searchForUser(employee.getEmail());
    }


    public void deleteEmployee(String id) {
        try {
            Long LongId = Long.parseLong(id);
            employeeRepository.deleteById(LongId);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException("Enter id as a number ");
        }

    }
    public void deleteCustomer(String id) {
        try {
            Long LongId = Long.parseLong(id);
            customerRepository.deleteById(LongId);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException("Enter id as a number");
        }

    }

    public void changeEmployeeUsername(String id ,String value) {
        Long LongId = Long.parseLong(id);
        System.out.println(LongId);
        employeeRepository.updateEmployeeUsername(LongId,value);
    }

    public void changeEmployeePassword(String id,String value) {
        Long LongId = Long.parseLong(id);
        employeeRepository.updateEmployeePassword(LongId,value);
    }

    public void changeEmployeePositon(String id,String value) {
        Long LongId = Long.parseLong(id);
        employeeRepository.updateEmployeePositon(LongId,value);
    }

    public void changeEmployeeEmail(String id,String value) {
        Long LongId = Long.parseLong(id);
        employeeRepository.updateEmployeeEmail(LongId,value);
    }

    public void changeEmployeeSalary(String id,String value) {
        Long LongId = Long.parseLong(id);
        Float salary = Float.parseFloat(value);
        employeeRepository.updateEmployeeSalary(LongId,salary);
    }
}
