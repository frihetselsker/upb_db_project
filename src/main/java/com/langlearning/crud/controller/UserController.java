package com.langlearning.crud.controller;


import com.langlearning.crud.entity.user.LanguageProficiency;
import com.langlearning.crud.entity.user.User;
import com.langlearning.crud.entity.user.UserProfile;
import com.langlearning.crud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/update")
    public ResponseEntity<User> updateEntity(@RequestBody User entity) {
        return userService.updateEntity(entity);
    }

    @PostMapping("/update-profile/{id}")
    public ResponseEntity<User> updateProfile(@RequestBody UserProfile entity, @PathVariable int id) {
        return userService.updateProfile(id, entity);
    }

    @PostMapping("/update-lp/{id}")
    public ResponseEntity<User> updateLanguageProficiency(@RequestBody LanguageProficiency languageProficiency, @PathVariable int id) {
        return userService.updateLanguageProficiency(id, languageProficiency);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }


}
