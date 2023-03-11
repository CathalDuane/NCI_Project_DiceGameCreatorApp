package com.example.demo.controllers;

import com.example.demo.player.Player;
import com.javadevjournal.system.exception.UserAlreadyExistException;

import com.javadevjournal.web.data.user.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import static com.javadevjournal.ApplicationConstant.REDIRECT;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(final Model model){
        model.addAttribute("Player", new Player());
        return "account/register";
    }

    @PostMapping("/register")
    public String userRegistration(final @Valid  Player player, final BindingResult bindingResult, final Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("registrationForm", player);
            return "account/register";
        }
        try {
            userService.register(player);
        }catch (UserAlreadyExistException e){
            bindingResult.rejectValue("email", "userData.email","An account already exists for this email.");
            model.addAttribute("registrationForm", player);
            return "account/register";
        }
        return REDIRECT+"/starter";
    }
}