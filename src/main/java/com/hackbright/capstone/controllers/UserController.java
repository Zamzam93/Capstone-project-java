package com.hackbright.capstone.controllers;
import com.hackbright.capstone.dtos.UserDto;
import com.hackbright.capstone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    // auto-wire dependencies.
    // controller communicates with services layers
    // password encoder helps so that it can received incoming passwords
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register") // @RequestBody so that the JSON request body becomes usable to us
    public List<String> addUser(@RequestBody UserDto userDto){
        String passHash = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(passHash);
        return userService.addUser(userDto);
    }

    @PostMapping("/login") // @RequestBody so that the JSON request body becomes usable to us
    public List<String> userLogin(@RequestBody UserDto userDto) { // method for logging a User in
        return userService.userLogin(userDto);

    }

}
