package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.ConfirmationToken;
import lv.accenture.bootcamp.rardb4.model.Role;
import lv.accenture.bootcamp.rardb4.model.User;
import lv.accenture.bootcamp.rardb4.repository.ConfirmationTokenRepository;
import lv.accenture.bootcamp.rardb4.repository.UserRepository;
import lv.accenture.bootcamp.rardb4.service.EmailSenderService;
import lv.accenture.bootcamp.rardb4.service.UserService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;
    @Autowired
    private DelegatingPasswordEncoder delegatingPasswordEncoder;

    @GetMapping(value = {"/login"})
    public ModelAndView login(BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @GetMapping(value = "/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("userAth/registration");
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByUserName(user.getUserName());
        if (userExists != null) {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "There is already a user registered with the user name provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("userAth/registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User(user.getId(), user.getUserName(), user.getEmail(),
                    user.getPassword(), user.getName(), user.getLastName(), user.getActive(), user.getProfileIconURL(),
                    user.getRoles()));
            modelAndView.setViewName("userAth/registration");

        }
        return modelAndView;
    }


    @RequestMapping(value = "/password/forgot", method = RequestMethod.GET)
    public ModelAndView displayResetPassword(ModelAndView modelAndView, User user) {
        modelAndView.addObject("user", user);
        modelAndView.setViewName("userAth/forgotPassword/forgot");
        return modelAndView;
    }


    @RequestMapping(value = "/forgot-password", method = RequestMethod.POST)
    public ModelAndView forgotUserPassword(ModelAndView modelAndView, User user) {
        User existingUser = userRepository.findByEmailIgnoreCase(user.getEmail());
        if (existingUser != null) {

            ConfirmationToken confirmationToken = new ConfirmationToken(existingUser);
            confirmationTokenRepository.save(confirmationToken);
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(existingUser.getEmail());
            mailMessage.setSubject("Complete Password Reset!");
            mailMessage.setFrom("javafunboot@gmail.com");
            mailMessage.setText("To complete Your password reset process, please follow the link: "
                    + "http://localhost:8080/confirm-reset?token=" + confirmationToken.getConfirmationToken());
            emailSenderService.sendEmail(mailMessage);
            modelAndView.addObject("message", "Request to reset password received. Check your inbox for the reset link.");
            modelAndView.setViewName("userAth/forgotPassword/success");

        } else {
            modelAndView.addObject("message", "This email does not exist!");
            modelAndView.setViewName("userAth/forgotPassword/error");
        }

        return modelAndView;
    }


    @RequestMapping(value = "/confirm-reset", method = RequestMethod.GET)
    public ModelAndView validateResetToken(ModelAndView modelAndView, @RequestParam("token") String confirmationToken) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        User user = userRepository.findByEmailIgnoreCase(token.getUser().getEmail());
        user.setPassword(null);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("userAth/forgotPassword/reset");
        return modelAndView;
    }

    @RequestMapping(value = "/confirm-reset", method = RequestMethod.POST)
    public ModelAndView validateResetTokenPost(ModelAndView modelAndView, @RequestParam("token") String confirmationToken) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        User user = userRepository.findByEmailIgnoreCase(token.getUser().getEmail());

        if (token != null &&  user.getActive()!=true ) {

            userRepository.save(user);
            modelAndView.addObject("email", user.getEmail());
            modelAndView.setViewName("userAth/forgotPassword/reset");
        }
        else {
            modelAndView.addObject("message", "The link is invalid or broken!");
            modelAndView.setViewName("userAth/forgotPassword/error");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
    public ModelAndView resetUserPassword(ModelAndView modelAndView, User user) {
        if (user.getEmail() != null) {
            User tokenUser = userRepository.findByEmailIgnoreCase(user.getEmail());
            tokenUser.setActive(true);
            tokenUser.setPassword(delegatingPasswordEncoder.encode(user.getPassword()));
            userRepository.save(tokenUser);
            modelAndView.addObject("message", "Password successfully reset. You can now log in with the new credentials.");
            modelAndView.setViewName("userAth/resetPassword/success");
        } else {
            modelAndView.addObject("message", "The link is invalid or broken!");
            modelAndView.setViewName("userAth/forgotPassword/error");
        }

        return modelAndView;
    }


}