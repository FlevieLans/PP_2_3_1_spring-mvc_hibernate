package app.controller;

import app.entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import app.service.UserService;

@Controller
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) { this.userService = userService; }


    @ModelAttribute("newUser")
    public User getPerson() { return new User(); }

    @GetMapping("/")
    public String showAllUsers(Model model){
        model.addAttribute("allUsers", userService.getAllUsers());
        return "index";
    }

    @PostMapping("/")
    public String addNewUser(@ModelAttribute("newUser") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("allUsers", userService.getAllUsers());
            return "index";
        }
        userService.saveUser(user);
        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String deleteUser(@ModelAttribute("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@ModelAttribute("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { return "edit"; }
        userService.saveUser(user);
        return "redirect:/";
    }

}