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

    String averageRatingValue = "SELECT AVG(r.value) FROM Rating r WHERE r.reviewId = :reviewID";
  //  String averageRatingForOtherUser = "SELECT AVG(r.review_rating) FROM Review r WHERE r.username = :username";
//    String averageRatingForSelf = "SELECT AVG(r.review_rating) FROM Review r WHERE r.userId = :userID";

      @Query(averageRatingValue)
      int average(@Param(value = "reviewID") Long reviewID);

//    @Query(averageRatingForSelf)
//    int selfAverage(@Param(value = "userID") Long userId);

//    @Query(averageRatingForOtherUser)
//    int otherUserAverage(@Param(value = "username") String username);


    List<Rating> findByReviewId(@Param(value="reviewId") Long reviewId);

    List<Rating>findAllByReviewId(Long reviewId);


}