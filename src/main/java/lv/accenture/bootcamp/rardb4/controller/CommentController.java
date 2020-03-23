package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.*;
import lv.accenture.bootcamp.rardb4.repository.CommentRepository;
import lv.accenture.bootcamp.rardb4.repository.MovieRepository;
import lv.accenture.bootcamp.rardb4.repository.ReviewRepository;
import lv.accenture.bootcamp.rardb4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

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

    //Getting user's comment input from user to put in DB
/*    @GetMapping("/reviews-search/rate-review/{id}/comments/add")
    public String addCommentInput(Model model) {
        model.addAttribute("comment", new Comment());
        return "rate-review";
    }*/


    @PostMapping("/reviews-search/rate-review/comment/{id}")
    public String addComment(@PathVariable Long id, @Valid Comment commentToAdd, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "rate-review";
        }
        String timeStamp = new SimpleDateFormat("HH:mm/dd-MM-yyyy").format(new Timestamp(System.currentTimeMillis()));

        commentToAdd.setReviewID(id);
        commentToAdd.setTimestamp(timeStamp);
        commentRepository.save(commentToAdd);
        return "redirect:/";
    }

}