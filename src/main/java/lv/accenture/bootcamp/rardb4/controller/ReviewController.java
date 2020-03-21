package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.Movie;
import lv.accenture.bootcamp.rardb4.model.ReadyReview;
import lv.accenture.bootcamp.rardb4.model.Review;
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
import java.util.*;

@Controller
public class ReviewController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/reviews") //relative link to reviews
    public String reviewIndex(Model model) {

        Iterable<Review> reviews = reviewRepository.findAll();
        model.addAttribute("reviews", reviews);

        return "/reviews-on-movie-index";//all reviews are here
    }

//
//    @GetMapping("/reviews/edit/{id}")
//    public String editReviewPage(@PathVariable Long id, Model model) {
//        Optional<Review> reviewToEdit = reviewRepository.findById(id);
//        model.addAttribute("review", reviewToEdit.get());
//        return "edit-review";
//    }
//
//    @PostMapping("/reviews/edit-review/{id}")
//    public String editCat(@PathVariable Long id, @Valid Review editedReview, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "edit-review";
//        }
//        editedReview.setId(id);
//        reviewRepository.save(editedReview);
//        return "redirect:/cats";
//    }

    @GetMapping("/reviews/delete-review/{id}")
    public String deleteReview(@PathVariable Long id) {
        reviewRepository.deleteById(id);
        return "redirect:/reviews";
    }


    @GetMapping("/reviews-search")
    public String searchReviewsByMovieTitle(@RequestParam String movieTitle, Model model) {
        List<Review> matchedReviews = reviewRepository.findByMovieTitle(movieTitle);

        // Ielādējām no DB atrastas filmas pēc to ID
        Set<String> movieIDS = new HashSet<>();
        for (Review matchedReview : matchedReviews) {
            movieIDS.add(matchedReview.getMovieID());
        }
        Iterable<Movie> matchedMovies = movieRepository.findAllById(movieIDS);

        // Taisam no tām Map<> kur atslēga ir imdbID un vērtība - pati filma,
        // lai tālāk vārētu ātri tos dabūt
        Map<String, Movie> movieMap = new HashMap<>();
        for (Movie matchedMovie : matchedMovies) {
            movieMap.put(matchedMovie.getImdbID(), matchedMovie);
        }

        // Veidojam kollekciju no ReadyReview, kur ieliekam vērtības gan no Review, gan no Movie
        List<ReadyReview> readyReviews = new ArrayList<>();
        for (Review matchedReview : matchedReviews) {
            Movie movie = movieMap.get(matchedReview.getMovieID());

            ReadyReview readyReview = new ReadyReview(
                    movie.getImdbID(), matchedReview.getReviewRating(),
                    matchedReview.getReviewTitle(), movie.getTitle(),
                    movie.getPoster(), matchedReview.getReviewText(),
                    matchedReview.getUserRatingForMovie(), matchedReview.getUserName()
            );

            readyReviews.add(readyReview);
        }


        model.addAttribute("reviews", readyReviews);
        return "reviews-on-movie";
    }


}