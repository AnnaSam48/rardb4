package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.Movie;
import lv.accenture.bootcamp.rardb4.model.User;
import lv.accenture.bootcamp.rardb4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String userIndex(Model model) {

        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);

        return "users-index";
    }

}
