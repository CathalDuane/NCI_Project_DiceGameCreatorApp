package com.example.demo.controllers;

import com.example.demo.player.Player;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SignUpController {

    @GetMapping("/signup")
    public String signUp(Model model){
        model.addAttribute("message", "Hello World");
        return "signup";
    }


}
