package com.app.RollToo.controller;

import com.app.RollToo.entity.User;
import com.app.RollToo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AppController {
    @Autowired
    private UserRepository repo;

    @GetMapping("/")
    public String viewHomepage(){

        return "index";
    }




    @GetMapping("/register")
    public String showSignUp(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    //code handling method
    //handles inputted data from registration page and sends it to the database
    @PostMapping("/process_register")
    public String processRegistration(User user){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);


        repo.save(user);

        return"register_success";
    }

    @GetMapping("/list_users")
    public String userList(){
        return "users";
    }

    @GetMapping("/profile")
    public String viewProfile(){
        return "profile";
    }

    @GetMapping("/calculator")
    public String viewCalculator(){
        return "calculator";
    }

    @GetMapping("/characterCreation")
    public String viewCharacterCreation(){
        return "characterCreation";
    }

    @GetMapping("/profileDetails")
    public String viewProfilerDetails(){
        return "profileDetails";
    }
}

