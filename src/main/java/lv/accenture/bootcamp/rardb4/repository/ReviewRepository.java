package lv.accenture.bootcamp.rardb4.repository;

import lv.accenture.bootcamp.rardb4.model.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

    String searchByMovie = "SELECT r FROM Review r JOIN Movie m ON r.movieID = m.imdbID WHERE m.Title LIKE %:movieTitle%";

    List<Review> findAll();
    List<Review> findAllByOrderByUserRatingForMovieDesc();
    List<Review> findTop10ByOrderByUserRatingForMovieDesc();
    List<Review> findTop5ByOrderByReviewRatingDesc();
    List<Review> findAllByOrderByReviewRatingDesc();
    List<Review> findAllByUsername(String username);
    List<Review> findAllByMovieID(String movieID);
    Optional<Review> findByReviewID(Long reviewID);
    List<Review> findTop10ByOrderByUserRatingForMovieDesc();
    @Query(searchByMovie)
    List<Review> findByMovieTitle(@Param(value="movieTitle") String movieTitle);


}
