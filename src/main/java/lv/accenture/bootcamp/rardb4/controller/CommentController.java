package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.*;
import lv.accenture.bootcamp.rardb4.repository.*;
import lv.accenture.bootcamp.rardb4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Controller
public class CommentController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserService userService;



    @PostMapping("/reviews-search/rate-review/comment/{id}")
    public String addComment(@PathVariable Long id, @Valid Comment commentToAdd, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "rate-review";
        }
        String timeStamp = new SimpleDateFormat("HH:mm/dd-MM-yyyy").format(new Timestamp(System.currentTimeMillis()));
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(loggedInUser.getName());

        commentToAdd.setReviewID(id);
       // commentToAdd.setUserId(user.getId());
        commentToAdd.setTimestamp(timeStamp);
        commentRepository.save(commentToAdd);
        return "redirect:/";
    }
}