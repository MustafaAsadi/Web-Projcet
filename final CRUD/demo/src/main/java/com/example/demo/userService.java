package com.example.demo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userService {
    private final userRepository userRepository;
    //@Autowired
    public userService(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Instagram_User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.removeUserById(id);
    }
    public void updateUser (Long id) {
        userRepository.updateById(id);
    }


    public void addUser() {
        //Instagram_User s = new Instagram_User("Karam","karam@neswan.com","i love her");
        //userRepository.save(s);
    }
}
