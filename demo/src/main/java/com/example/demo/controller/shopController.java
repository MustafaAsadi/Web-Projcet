package com.example.demo.controller;

import com.example.demo.classes.customer;
import com.example.demo.classes.employee;
import jakarta.servlet.http.HttpSession;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class shopController {

    private com.example.demo.service.shopService shopService;

    @Autowired
    private JavaMailSender emailSender;

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
        if(customer.getdateOfCreation() == null) {
            customer.setDateOfCreation();
        }
            if (customer.getPassword().contains("!") || customer.getPassword().contains("@") ||
                    customer.getPassword().contains("#") || customer.getPassword().contains("$") ||
                    customer.getPassword().contains("%") || customer.getPassword().contains("^") ||
                    customer.getPassword().contains("&") || customer.getPassword().contains("*") ||
                    customer.getPassword().contains("(") || customer.getPassword().contains(")") ||
                    customer.getPassword().contains("_") || customer.getPassword().contains("+") ||
                    customer.getPassword().contains("\"") || customer.getPassword().contains("'") ||
                    customer.getPassword().contains("\\") || customer.getPassword().contains("/") ||
                    customer.getPassword().contains(":") || customer.getPassword().contains(";") ||
                    customer.getPassword().contains(",") || customer.getPassword().contains("<") ||
                    customer.getPassword().contains(">") || customer.getPassword().contains(".") ||
                    customer.getPassword().contains("?")) {
                if(customer.getPassword().matches(".*[A-Z].*")) {
                    if(customer.getPassword().length()>8) {
                        if(customer.getPassword().matches(".*[0-9].*")) {
                            return shopService.registerCustomer(customer);
                        }
                        else  throw new IllegalArgumentException("the password must contains at least one number");
                    }
                    else throw new IllegalArgumentException("The password must contains at least 8 characters");
                }
                else throw new IllegalArgumentException("the password must contains at least one capital letter");
            }

        else
            throw new IllegalArgumentException(" the password must contains at least one speical character");
    }

    @RequestMapping(path = "/register/employee", method = RequestMethod.POST)
    public employee registerEmployee (@RequestBody Map<String,String> info) {
        String username = info.get("username");
        String password = info.get("password");
        String email = info.get("email");
        employee employee = new employee(username,password,email);
        if (employee.getPassword().contains("!") || employee.getPassword().contains("@") ||
                employee.getPassword().contains("#") || employee.getPassword().contains("$") ||
                employee.getPassword().contains("%") || employee.getPassword().contains("^") ||
                employee.getPassword().contains("&") || employee.getPassword().contains("*") ||
                employee.getPassword().contains("(") || employee.getPassword().contains(")") ||
                employee.getPassword().contains("_") || employee.getPassword().contains("+") ||
                employee.getPassword().contains("\"") || employee.getPassword().contains("'") ||
                employee.getPassword().contains("\\") || employee.getPassword().contains("/") ||
                employee.getPassword().contains(":") || employee.getPassword().contains(";") ||
                employee.getPassword().contains(",") || employee.getPassword().contains("<") ||
                employee.getPassword().contains(">") || employee.getPassword().contains(".") ||
                employee.getPassword().contains("?")) {
            if(employee.getPassword().length()>8) {
                if(employee.getPassword().matches(".*[0-9].*")) {
                    return shopService.registerEmployee(employee);
                }
                else  throw new IllegalArgumentException("the password must contains at least one number");
            }
            else throw new IllegalArgumentException("The password must contains at least 8 characters");
        }
        else
            throw new IllegalArgumentException(" the password must contains at least one speical character");
    }



    @RequestMapping(path = "/login/customer", method = RequestMethod.POST)
    public String loginCustomer(@RequestBody Map<String,String> credentials, HttpSession session) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        if(email == null || password == null) {
            throw new IllegalArgumentException("Enter email and password");
        }

        customer customer = new customer(email,password);
        if (shopService.findCustomerByEmail(customer).isPresent() & shopService.findCustomerByPassword(customer).isPresent()) {
            session.setAttribute("loggedIn",shopService.getCustomerInfo(customer));
            return "redirect:/dashboard/customer";
        } else {
            throw new IllegalStateException("Invalid email/password");
        }

    }

    @RequestMapping(path = "dashboard/customer", method = RequestMethod.POST)
    public customer getCustomerInfo(HttpSession session,Model model) {
        customer loggedIn = (customer) session.getAttribute("loggedIn");
        return shopService.getCustomerInfo(loggedIn);

    }
    //--------------------------------------------------------------------------------------------------
    @RequestMapping(path = "dashboard/employee", method = RequestMethod.POST)
    public employee getEmployeeInfo(HttpSession session) {
        employee loggedIn = (employee) session.getAttribute("loggedInEmployee");
        return shopService.getEmployeeInfo(loggedIn);

    }

    @RequestMapping(path = "/login/employee", method = RequestMethod.POST)
    public ResponseEntity<String> loginEmployee(@RequestBody Map<String,String> credentials, HttpSession session) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        if(email == null || password == null) {
            throw new IllegalArgumentException("Enter email and password");
        }

        employee employee = new employee(email,password);
        if (shopService.findEmployeeByEmail(employee).isPresent() & shopService.findEmployeeByPassword(employee).isPresent()) {
            session.setAttribute("loggedInEmployee",shopService.getEmployeeInfo(employee));
            return ResponseEntity.ok("Login successful");
        } else {
            throw new IllegalStateException("Invalid email/password");
        }

    }
    @RequestMapping(path="/dashboard/employee/admin",method = RequestMethod.POST)
    public String adminBoard(@RequestBody Map<String,String> request,HttpSession session){
        employee admin = (employee) session.getAttribute("loggedInEmployee");
        String choice = request.get("choice");
        String position = shopService.getEmployeeInfo(admin).getPosition();
        System.out.println("the position is:" +position);
        if(position.equals("admin")) {
            if (choice.equals("update")){
                return "redirect:/dashboard/employee/admin/update";
            }
            if (choice.equals("delete")) {
                return "redirect:/dashboard/employee/admin/delete";
            }
        }
        System.out.println("Received choice: " + choice);
        return "redirect:/dashboard/employee";
    }
    @RequestMapping(path ="/dashboard/employee/admin/delete",method = RequestMethod.DELETE)//change to RequestMethod.DELETE
    public void operationDelete(@RequestBody Map <String,String> userToDelete) {
        String type = userToDelete.get("type");
        String id = userToDelete.get("id");
        if(type.equals("employee")) {
            shopService.deleteEmployee(id);
        }
        if(type.equals("customer")) {
            shopService.deleteCustomer(id);
        }
    }

    @RequestMapping(path ="/dashboard/employee/admin/update",method = RequestMethod.PATCH)//change to RequestMethod.PATCH
    public void operationUpdate(@RequestBody Map <String,String> change){//Only on employees
        String column = change.get("column");
        String id = change.get("id");
        String value = change.get("value");
        switch (column) {
            case "username":
                shopService.changeEmployeeUsername(id,value);
                break;
            case "password":
                shopService.changeEmployeePassword(id,value);
                break;
            case "position":
                shopService.changeEmployeePositon(id,value);
                break;
            case "email":
                shopService.changeEmployeeEmail(id,value);
                break;
            case "salary":
                shopService.changeEmployeeSalary(id,value);
                break;

        }
    }

@RequestMapping(path = "/login/customer/requestChangePassword" ,method = RequestMethod.POST)
    public void  passwordReset(@RequestBody Map<String,String> Tokenemail, HttpSession session) {
    String email = Tokenemail.get("email");
    System.out.println(shopService.CheakForEmail(email));
    if(shopService.CheakForEmail(email)==null) {
        throw new IllegalStateException("There is no such email has an account");
    }
    else {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("memoahmad20022@gmail.com");
        message.setTo(email);
        message.setSubject("Password retrival");
        message.setText(
                "you can retrive your password from this url:http://localhost:8080/api/v1/login/customer/resetpassword"
        );
        System.out.println("EMAIL SENT RIGHT");
        System.out.println(message);
        emailSender.send(message);
        session.setAttribute(email,"transition");
    }


}
    @RequestMapping(path = "/login/customer/resetpassword" ,method = RequestMethod.PATCH)
    public void changePassword(@RequestBody Map<String,String> tokenpassword,HttpSession session) {
        String password = tokenpassword.get("email");
        String email = (String) session.getAttribute("transition");
        shopService.resetPassword(password,email);
    }
}
//TODO JWT