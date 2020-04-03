package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.configuration.SecurityConfiguration;
import lv.accenture.bootcamp.rardb4.model.ReadyReview;
import lv.accenture.bootcamp.rardb4.model.Review;
import lv.accenture.bootcamp.rardb4.model.User;
import lv.accenture.bootcamp.rardb4.repository.MovieRepository;
import lv.accenture.bootcamp.rardb4.repository.ReviewRepository;
import lv.accenture.bootcamp.rardb4.repository.UserRepository;
import lv.accenture.bootcamp.rardb4.service.UserService;
import lv.accenture.bootcamp.rardb4.service.UserWithId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.*;

@Controller
public class UserController {


    @Autowired
    UserRepository userRepository;

    @Autowired
    private DelegatingPasswordEncoder delegatingPasswordEncoder;


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

    @GetMapping(value = "/admin/home") //didn't have extra time to make admin interface
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
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
        modelAndView.setViewName("user/userProfile");
        return modelAndView;
    }

    @GetMapping("user/home/profile/edit")
    public String editUserPage(Model model, Principal principal) {
        User user = userService.findUserByUserName(principal.getName());
        Long userId = user.getId();
        User userToEdit = userRepository.findById(userId);
        model.addAttribute("user", userToEdit);
        return "user/edit-user";
    }

    @PostMapping("user/home/profile/edit") //not working in the best way
    public String editUser(@Valid User editedUser, Principal principal) {
        User user = userService.findUserByUserName(principal.getName());
        Long userId = user.getId();
        editedUser.setId(userId);
        editedUser.setProfileIconURL("/static/img/500px-brands.svg");
        editedUser.setUserName(user.getUserName());
        userService.saveUser(editedUser);
        return "redirect:/user/home/profile";
    }

    @GetMapping("user/profile/updatePassword")
    public String passwordChange(Model model, Principal principal) {
        User user = userService.findUserByUserName(principal.getName());
        Long userId = user.getId();
        User userToEdit = userRepository.findById(userId);
        model.addAttribute("user", userToEdit);
        return "user/updatePassword";
    }


 /*   @PostMapping("user/profile/updatePassword") //not working
    public String changeUserPassword(User user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.findUserByUserName(auth.getName());

        currentUser.setId(currentUser.getId());

        SecurityConfiguration securityConfig = new SecurityConfiguration();
        PasswordEncoder passwordEncoders =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();

        String password = currentUser.getPassword();
        String newPassword =currentUser.getPassword();
        String confirmPassword =currentUser.getPassword();

        if (null != newPassword)
            if (passwordEncoders.matches(newPassword, confirmPassword)) {
                if (password != null && !password.isEmpty() && !password.equals("")) {
                    currentUser.setPassword(delegatingPasswordEncoder.encode(newPassword));

                }
                currentUser.setEmail(currentUser.getEmail());
            } else {
                return "/error";
            }


        currentUser.setName(currentUser.getName());
        currentUser.setLastName(currentUser.getLastName());
        currentUser.setUserName(currentUser.getUserName());


        userService.saveUser(currentUser);


        //user.setPassword(delegatingPasswordEncoder.encode(user.getPassword()));
        //userService.saveUser(user);
        return "redirect:/user/home/profile";
        //new GenericResponse(messages.getMessage("message.updatePasswordSuc", null, locale));
    }
*/

}