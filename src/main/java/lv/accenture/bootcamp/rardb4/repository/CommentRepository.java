package lv.accenture.bootcamp.rardb4.repository;

import lv.accenture.bootcamp.rardb4.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;


@Repository
public interface CommentRepository extends CrudRepository<Comment, Flux> {

    String searchAllByReviewId = "SELECT c FROM Comment c JOIN Review r on c.reviewID = r.movieID";

    Iterable<Comment> findAll();
    @Query(searchAllByReviewId)
    List<Comment> findByReviewId(@Param(value = "reviewID") Long reviewID);
}
