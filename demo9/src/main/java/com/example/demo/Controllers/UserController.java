package com.example.demo.Controllers;

import com.example.demo.Entities.User;
import com.example.demo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/allusers")
    public String index(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        User user = new User();
        model.addAttribute("users", user);
        model.addAttribute("method", "POST");
      //  logger.info("category added");

        return "adduser";
    }

    @PostMapping("/new")
    public String saveCategory( @ModelAttribute("users") User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("users", user);
            model.addAttribute("method", "POST");

            return "adduser";
        }
        userService.saveUser(user);
        return "redirect:/users/allusers";
    }
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable(value="id") Long id, Model model){

        Optional<User> user = userService.getUserById(id);
        model.addAttribute("users", user.get());
        model.addAttribute("method", "PUT");
        return "adduser";
    }

    @PutMapping("/edit/{id}")
    public String updateUser( @ModelAttribute("category") User user, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("users", user);
            model.addAttribute("method", "PUT");
            return "adduser";
        }
        userService.saveUser(user);
        return "redirect:/users/allusers";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable(value="id") Long id, Model model){
        userService.deleteUserById(id);


        return "redirect:/users/allusers";
    }



}
