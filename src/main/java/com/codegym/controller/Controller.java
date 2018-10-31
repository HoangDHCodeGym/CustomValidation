package com.codegym.controller;

import com.codegym.model.PhoneNumber;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
    @GetMapping("/")
    public String index(Model model) {
        PhoneNumber phoneNumber = new PhoneNumber();
        model.addAttribute("phone", phoneNumber);
        return "index";
    }

    @PostMapping("/")
    public String result(@Valid @ModelAttribute PhoneNumber phone, BindingResult bindingResult, Model model) {
        System.out.println("Hello");
        new PhoneNumber().validate(phone, bindingResult);
        model.addAttribute("phone", phone);
        if (bindingResult.hasFieldErrors()) {
            return "index";
        } else {
            model.addAttribute("message", "Number received");
            return "index";
        }
    }

}
