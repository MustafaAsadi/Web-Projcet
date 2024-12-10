package com.example.demo.controller;

import com.example.demo.classes.customer;
import com.example.demo.classes.employee;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;


@RestController
@RequestMapping("/api/v1")
public class shopController {

    private com.example.demo.service.shopService shopService;

    @Autowired
    public shopController(com.example.demo.service.shopService shopService) {
        this.shopService = shopService;
    }


    @RequestMapping()
    public String hello() {
        return "hi";
    }

    @RequestMapping(path = "/customers")
    public List<customer> getAllCustomers() {
        return shopService.getAllCustomers();
    }



    @RequestMapping(path = "/register/customer", method = RequestMethod.POST)
    public customer registerCustomer (@RequestBody customer customer) {
        return shopService.registerCustomer(customer);
    }

    @RequestMapping(path = "/register/employee", method = RequestMethod.POST)
    public employee registerEmployee (@RequestBody employee employee) {
        return shopService.registerEmployee(employee);
    }



    @RequestMapping(path = "/login/customer", method = RequestMethod.POST)
    public String loginCustomer(@RequestBody Map<String,String> credentials, HttpSession session) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        if(username == null || password == null) {
            throw new IllegalArgumentException("Enter username and password");
        }

        customer customer = new customer(username,password);
        if (shopService.findCustomerByUsername(customer).isPresent() & shopService.findCustomerByPassword(customer).isPresent()) {
            session.setAttribute("loggedIn",shopService.getCustomerInfo(customer));
            return "redirect:/dashboard/customer";
        } else {
            throw new IllegalStateException("Invalid username/password");
        }

    }

    @RequestMapping(path = "dashboard/customer", method = RequestMethod.POST)
    public customer getCustomerInfo(HttpSession session,Model model) {
        customer loggedIn = (customer) session.getAttribute("loggedIn");
        return shopService.getCustomerInfo(loggedIn);

    }

    @RequestMapping(path = "dashboard/employee", method = RequestMethod.POST)
    public employee getEmployeeInfo(HttpSession session) {
        employee loggedIn = (employee) session.getAttribute("loggedIn");
        return shopService.getEmployeeInfo(loggedIn);

    }

    @RequestMapping(path = "/login/employee", method = RequestMethod.POST)
    public Object loginEmployee(@RequestBody Map<String,String> credentials, HttpSession session) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        if(username == null || password == null) {
            throw new IllegalArgumentException("Enter username and password");
        }

        employee employee = new employee(username,password);
        if (shopService.findEmployeeByUsername(employee).isPresent() & shopService.findEmployeeByPassword(employee).isPresent()) {
            session.setAttribute("loggedIn",shopService.getEmployeeInfo(employee));
            return "redirect:/dashboard/employee";
        } else {
            throw new IllegalStateException("Invalid username/password");
        }



}
}
