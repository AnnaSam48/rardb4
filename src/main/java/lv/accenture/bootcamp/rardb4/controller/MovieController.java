package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;


    @GetMapping("/add-review-search")
    public String searchMovieToAdd(Model model){

    //model.addAttribute("movies", movieRepository.findAll())
        return"add-review-search";
    }
}
