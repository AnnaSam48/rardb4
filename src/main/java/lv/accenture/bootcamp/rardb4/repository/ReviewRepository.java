package lv.accenture.bootcamp.rardb4.repository;

import lv.accenture.bootcamp.rardb4.model.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

    String searchByMovie = "SELECT r FROM Review r JOIN Movie m ON r.movieID = m.imdbID WHERE m.Title LIKE %:title%";

    @Query(searchByMovie)
    List<Review> findByMovieTitle(@Param(value="title") String title);

}
