package lv.accenture.bootcamp.rardb4.repository;

import lv.accenture.bootcamp.rardb4.model.Rating;
import lv.accenture.bootcamp.rardb4.model.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends CrudRepository<Rating,Long> {

    String averageRatingValue = "SELECT AVG(r.value) FROM Rating r JOIN Review rev ON r.reviewId = rev.reviewID";


    @Query(averageRatingValue)
    int average(@Param(value = "reviewid") Long reviewID);
    List<Rating> findByReviewId(@Param(value="reviewId") Long reviewId);

    List<Rating>findAllByReviewId(Long reviewId);


}