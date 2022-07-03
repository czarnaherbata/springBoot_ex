package com.example.demo.Controllers;

import com.example.demo.Entities.User;
import com.example.demo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/allusers")
    public String index(Model model){
        model.addAttribute("user", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("method", "POST");
      //  logger.info("category added");

        return "adduser";
    }

    @PostMapping("/new")
    public String saveCategory( @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("method", "POST");

            return "adduser";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }


}
