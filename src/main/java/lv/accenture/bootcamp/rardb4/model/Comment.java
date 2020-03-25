package lv.accenture.bootcamp.rardb4.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "commentid")
    private Long commentID;

    @Column(name = "reviewid")
    private Long reviewID;

    @Column(name = "comment_text")
    private String commentText;

    @Column(name = "comment_username")
    private String commentUsername;

    @Column(name = "timestamp")
    private String timestamp;
    private Long userId;
    private String movieTitle;
    private String movieID;




    @JoinColumn(name = "reviewid")
    private Review commentReview;

    public Comment() {

    }

    public Comment(Long commentID, Long reviewID, String commentText, String commentUsername, String timestamp, Long userId, String movieTitle, String movieID) {
        this.commentID = commentID;
        this.reviewID = reviewID;
        this.commentText = commentText;
        this.commentUsername = commentUsername;
        this.timestamp = timestamp;
        this.userId = userId;
        this.movieTitle = movieTitle;
        this.movieID=movieID;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Long getCommentID() {
        return commentID;
    }

    public void setCommentID(Long commentID) {
        this.commentID = commentID;
    }

    public Long getReviewID() {
        return reviewID;
    }

    public void setReviewID(Long reviewID) {
        this.reviewID = reviewID;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getCommentUsername() {
        return commentUsername;
    }

    public void setCommentUsername(String commentUsername) {
        this.commentUsername = commentUsername;
    }


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentID=" + commentID +
//                ", reviewID=" + reviewID +
                ", commentText='" + commentText + '\'' +
                ", commentUsername='" + commentUsername + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}