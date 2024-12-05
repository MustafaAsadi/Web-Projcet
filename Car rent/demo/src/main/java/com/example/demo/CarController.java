package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class CarController {
private final CarService CarService;
    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    public CarController(CarService CarService) {
        this.CarService = CarService;
    }


    @GetMapping("/info")
    public List<Cars> getAllInfo() {
        return CarService.getAllInfo();
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Optional<Cars> login (@RequestBody Cars Car) {
        if(CarService.FindAccount(Car).isPresent()){
           return CarService.getinfo(Car);
        }
        else {
            throw new IllegalStateException("Invalid username/password");
        }

    }

   //@GetMapping("/password")
    //public String password() {
       // return "password:";
    //}
}
