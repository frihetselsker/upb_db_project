package com.langlearning.crud.service;

import com.langlearning.crud.repository.user.UserRepository;
import com.langlearning.crud.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Object getAllUsers() {
        return userRepository.findAll();
    }

    public Object getUserById(int id) {
        if (userRepository.findByUserId(id).isPresent()) {
            return userRepository.findByUserId(id).get();
        } else {
            return new Response(-1, "User not found");
        }
    }




}
