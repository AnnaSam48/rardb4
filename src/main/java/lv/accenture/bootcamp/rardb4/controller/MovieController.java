package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.MovieAPI.MovieAPIService;
import lv.accenture.bootcamp.rardb4.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    MovieAPIService movieAPIService;

    @GetMapping("/add-review-search")
    public String addReviewSearchPage(Model model) {

        return "add-review-search";
    }

    @GetMapping("/add-review-search/search")
    public String searchMoviesByKeyword(Model model, @RequestParam String keyword) {
        List<Movie> foundMovies = movieAPIService.getMovie(keyword);
        model.addAttribute("movies", foundMovies);
        return "add-review-search"; //if we do redirect then we loose parameter
    }


}
