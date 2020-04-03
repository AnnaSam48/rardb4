package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.*;
import lv.accenture.bootcamp.rardb4.repository.*;
import lv.accenture.bootcamp.rardb4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${simple.date.format}")
    private String dateformat;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/reviews-search/rate-review/comment/{id}")
    public String addComment(@PathVariable Long id, @Valid Comment commentToAdd, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "rate-review";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        String username =  user.getUserName();

        commentToAdd.setReviewID(id);
        commentToAdd.setUsername(username);
      //  commentToAdd.setTimestamp();
        commentRepository.save(commentToAdd);

        String path = "redirect:/reviews-search/rate-review/" + id.toString();

        return path;
    }
}