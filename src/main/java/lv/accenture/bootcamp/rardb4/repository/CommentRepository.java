package lv.accenture.bootcamp.rardb4.repository;

import lv.accenture.bootcamp.rardb4.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    Iterable<Comment> findAll();

    List<Comment> findByReviewID(@Param(value = "reviewID") Long reviewID);
}
