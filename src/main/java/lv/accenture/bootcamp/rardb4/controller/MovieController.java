package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.Movie;
import lv.accenture.bootcamp.rardb4.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/add-review-to-movie-search")
    public String movieIndex(Model model) {

        Iterable<Movie> movies = movieRepository.findAll();
        model.addAttribute("movies", movies);

        return "add-review-to-movie-search";
    }



}
