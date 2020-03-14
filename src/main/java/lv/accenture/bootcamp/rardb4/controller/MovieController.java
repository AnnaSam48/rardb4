package lv.accenture.bootcamp.rardb4.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MovieController {

//    @Autowired
//    private MovieRepository movieRepository;


    @GetMapping("/add-review-search")
    public String addReviewSearchPage(Model model) {


      //Iterable<Movie> movies = movieRepository.findAll();
    //model.addAttribute("movies", movies);
        return "add-review-search";
 }
}
