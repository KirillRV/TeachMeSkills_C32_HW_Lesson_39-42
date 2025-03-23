package com.tms.controller;

import com.tms.exception.AgeException;
import com.tms.model.User;
import com.tms.model.dto.RegistrationRequestDto;
import com.tms.service.SecurityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/security")
public class SecurityController {

    private final SecurityService securityService;

    @Autowired
    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("registrationRequestDto", new RegistrationRequestDto()); //Pre-populate the model
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("registrationRequestDto") @Valid RegistrationRequestDto requestDto,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            //Improved error handling:  Let Spring handle the errors in the view.
            return "registration";
        }

        Optional<User> resultUser = securityService.registration(requestDto);
        if (resultUser.isPresent()) {
            return "redirect:/user/" + resultUser.get().getId(); // Redirect to user details page.
        } else {
            //Add a message to the model to indicate failure.
            model.addAttribute("message", "Registration failed.");
            return "registration";
        }
    }
}