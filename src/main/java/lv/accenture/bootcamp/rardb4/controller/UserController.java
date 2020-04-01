package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.ReadyReview;
import lv.accenture.bootcamp.rardb4.model.Review;
import lv.accenture.bootcamp.rardb4.model.User;
import lv.accenture.bootcamp.rardb4.repository.MovieRepository;
import lv.accenture.bootcamp.rardb4.repository.ReviewRepository;
import lv.accenture.bootcamp.rardb4.repository.UserRepository;
import lv.accenture.bootcamp.rardb4.service.UserService;
import lv.accenture.bootcamp.rardb4.service.UserWithId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.*;

@Controller
public class UserController {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;


    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/home")
    public ModelAndView userHome(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findUserByUserName(principal.getName());
        modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("userMessage", "Content Available Only for Users");
        modelAndView.setViewName("user/home");
        return modelAndView;
    }

    @GetMapping("/user/home/profile")
    public ModelAndView userHomeProfile(Principal principal) {

        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findUserByUserName(principal.getName());
        modelAndView.addObject("profilePic", user.getProfileIconURL());
        modelAndView.addObject("userName", user.getUserName());
        modelAndView.addObject("nameUser", user.getName());
        modelAndView.addObject("last", user.getLastName());
        modelAndView.addObject("email", user.getEmail());
        modelAndView.addObject("userMessage", "Content Available Only for Users");
        modelAndView.setViewName("user/userProfile");
        return modelAndView;
    }

    @GetMapping("user/home/profile/edit")
    public String editUserPage(Model model, Principal principal) {
        //Authentication authentication = new UsernamePasswordAuthenticationToken(userObject, userObject.getPassword(), userObject.getAuthorities());
        //SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userService.findUserByUserName(principal.getName());
        Long userId = user.getId();
        User userToEdit = userRepository.findById(userId);
        model.addAttribute("user", userToEdit);
        return "user/edit-user";
    }

    @PostMapping("user/home/profile/edit")
    public ModelAndView editUser(@Valid User editedUser, BindingResult bindResult, Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findUserByUserName(principal.getName());
        Long userId = user.getId();
        editedUser.setId(userId);
        editedUser.setProfileIconURL("/static/img/500px-brands.svg");
        editedUser.setUserName(user.getUserName());
      /*  if username would be edited

      User userExists = userService.findUserByUserName(editedUser.getUserName());
        if (userExists != null && userExists!=user) {
            bindResult
                    .rejectValue("userName", "error.user",
                            "Sorry, user name already taken!");
        }

       */
        if (bindResult.hasErrors()) {
            modelAndView.setViewName("user/edit-user");
        } else {
            userService.saveUser(editedUser);
            modelAndView.setViewName("redirect:/user/home/profile");
        }
        return modelAndView;
    }
}
