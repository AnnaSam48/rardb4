package lv.accenture.bootcamp.rardb4.repository;

import lv.accenture.bootcamp.rardb4.model.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
  //  @Query("SELECT review FROM Review review WHERE review.reviewRating (highest)")
    List<Review> findByReviewRating(@Param(value = "reviewRating") double reviewRating);
}
