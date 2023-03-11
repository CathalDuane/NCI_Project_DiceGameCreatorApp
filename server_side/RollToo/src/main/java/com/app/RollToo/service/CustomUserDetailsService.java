package com.app.RollToo.service;

import com.app.RollToo.entity.User;
import com.app.RollToo.repo.UserRepository;
import com.app.RollToo.userdetails.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.*;


public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Email not found");
        }
        return new CustomUserDetails(user);
    }
    //method to delete existing player from database
//    public void deletePlayer(Long userId){
//        boolean userExists = UserRepository.existsById(userId);
//
//        if(!userExists){
//            throw new IllegalStateException("Player with id "+ userId+ " does not exist");
//        }
//
//        UserRepository.deleteById(userId);
//    }



}
