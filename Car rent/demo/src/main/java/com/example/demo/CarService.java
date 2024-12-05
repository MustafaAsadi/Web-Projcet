package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository CarRepository;

    @Autowired
    public CarService(CarRepository CarRepository) {
        this.CarRepository = CarRepository;
    }


    public List<Cars> getAllInfo(){
        return CarRepository.findAll();
    }
    public Optional<Cars> FindAccount (Cars Car) {
      Optional<Cars> user = CarRepository.searchByUsername(Car.getUserName());
      Optional<Cars> pass = CarRepository.searchByPassword(Car.getPassword());

      if(user.isPresent() & pass.isPresent())
        return user;
      else return null;
    }
    public Optional<Cars> getinfo(Cars car) {
       return CarRepository.findById(car.getId());
    }
}
