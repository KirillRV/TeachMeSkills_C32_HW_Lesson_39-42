package com.tms.controller;

import com.tms.model.User;
import com.tms.model.dto.UserDto;
import com.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create")
    public String getUserCreatePage(Model model) {
        model.addAttribute("userRequestDto", new UserDto());
        return "createUser";
    }

    @GetMapping("/update/{id}")
    public String getUserUpdatePage(@PathVariable Long id, Model model) {
        return userService.getUserById(id)
                .map(user -> {
                    model.addAttribute("user", user);
                    return "editUser";
                })
                .orElse("error");
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("userRequestDto") UserDto userRequestDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "createUser";
        }
        return userService.createUser(userRequestDto)
                .map(user -> "redirect:/user/" + user.getId())
                .orElse("error");
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        return userService.getUserById(id)
                .map(user -> {
                    model.addAttribute("user", user);
                    return "user";
                })
                .orElse("error");
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute UserDto userRequestDto, Model model) {
        userRequestDto.setId(id);
        return userService.updateUser(userRequestDto)
                .map(user -> "redirect:/user/" + user.getId())
                .orElse("error");
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        if (userService.deleteUser(id)) {
            return "redirect:/user/getAll";
        } else {
            model.addAttribute("message", "User deletion failed.");
            return "error";
        }
    }

    @GetMapping("/getAll")
    public String getUserListPage(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("usersEmpty", users.isEmpty()); // Add a flag to check for empty list
        return "users";
    }
}