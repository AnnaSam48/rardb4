package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.repository.MovieRepository;
import lv.accenture.bootcamp.rardb4.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;


    @GetMapping("/")
    public String toBestRatedReviews(Model model) {

       model.addAttribute("reviews",reviewRepository.findTop5ByOrderByReviewRatingDesc());

        return "index";
    }

}
