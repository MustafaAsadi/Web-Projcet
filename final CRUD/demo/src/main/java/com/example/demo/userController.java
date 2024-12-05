package com.example.demo;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class userController {
    private final userService userService ;

    @RequestMapping( path = "dashboard")
    public String dashboard () {
        return "Welcome to instagram <br> <br> --Home <br> <br> --Search <br> <br> --Reels <br> <br> --Account ";
    }
    @Autowired
    public userController(userService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "Users")
    public List<Instagram_User> getAllUsers() {
        return userService.getAllUsers();
    }


    @RequestMapping(value = "/user/{user_id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("user_id") Long id) {
        userService.deleteUser(id);  // Pass the ID to the service
    }
    @PostMapping
    public void registerUser() {
        userService.addUser();
    }
    @RequestMapping(value = "/user/{user_id}", method = RequestMethod.PATCH)
    public void updateUser(@PathVariable("user_id") Long id) {
        userService.updateUser(id);
    }


}

