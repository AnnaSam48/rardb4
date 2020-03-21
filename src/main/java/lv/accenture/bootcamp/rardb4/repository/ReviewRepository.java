package lv.accenture.bootcamp.rardb4.repository;

import lv.accenture.bootcamp.rardb4.model.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

    String searchByMovie = "SELECT r FROM Review r JOIN Movie m ON r.movieID = m.imdbID WHERE m.Title LIKE %:movieTitle%";
    String searchMovieTitleFromMovieId = "SELECT m.Title FROM Movie m JOIN Review r ON m.imdbID = r.movieID";
    String moviePosterURL = "SELECT m.Poster FROM Movie m JOIN Review r ON m.imdbID = r.movieID";
  //  String joinAllReviewsToUser = "SELECT r Review r JOIN User u ON r.userName = u.username";


    List<Review> findTop5ByOrderByReviewRatingDesc();

    //List<Review> findTop5ByOrderByIdAsc();

    @Query(searchByMovie)
    List<Review> findByMovieTitle(@Param(value="movieTitle") String movieTitle);

    @Query(searchMovieTitleFromMovieId)
    String movieTitleFromId(@Param(value="imdbID") String imdbID);

    @Query(moviePosterURL)
    String posterURL(@Param(value = "imdbID") String imdbID);

  /*  @Query(joinAllReviewsToUser)
    List<Review> allReviewsByUser(@Param(value = "userName") String userName);
*/

  /*@Query()
    List<Review>findByOrderByRatingReviewDesc();*/



}
