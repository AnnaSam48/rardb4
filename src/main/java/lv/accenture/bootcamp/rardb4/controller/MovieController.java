package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.Movie;
import lv.accenture.bootcamp.rardb4.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public String movieIndex(Model model) {

        Iterable<Movie> movies = movieRepository.findAll();
        model.addAttribute("movies", movies);

        return "movies-index";
    }

    @GetMapping("/add-review-search")
    public String searchMovieToAdd(Model model){

        model.addAttribute("movies", movieRepository.findAll());
        return"add-review-search";
    }


//    @GetMapping("/movie-to-add-review-to-search")
//    public String searchMovieToAdd(@RequestParam String movieName, Model model) {
//
//        List<Movie> matchedMovie = movieRepository.findByMovieName(movieName);
//        model.addAttribute("movies", matchedMovie);
//
//        return "movies-index";
//    }

    @PostMapping("/movies/add-movie")
    public String addMovie(@Valid Movie movieToAdd, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return "add-movie";
        }

        movieRepository.save(movieToAdd);

        return "redirect:/movies";
    }
}
