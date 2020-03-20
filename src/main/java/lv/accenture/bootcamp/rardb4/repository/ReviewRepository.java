package lv.accenture.bootcamp.rardb4.repository;

import lv.accenture.bootcamp.rardb4.model.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

    @Query("SELECT m FROM Movie m JOIN review ON review.movieID = movie.imdbID" +
            "WHERE m.title  LIKE %:title%")
    List<Review> findByMovieTitle(@Param(value = "title") String title);

}
