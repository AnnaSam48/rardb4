package lv.accenture.bootcamp.rardb4.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "commentid")
    private Long commentID;
//    @Column(name = "reviewid")
    private Long reviewID;
//    @Column(name = "comment_text")
    private String commentText;
//    @Column(name = "comment_username")
    private String commentUsername;
//    @Column(name = "timestamp")
    private String timestamp;

    public Comment() {

    }

    public Comment(Long commentID, Long reviewID, String commentText, String commentUsername, String timeStamp) {
        this.commentID = commentID;
        this.reviewID = reviewID;
        this.commentText = commentText;
        this.commentUsername = commentUsername;
        this.timestamp = timeStamp;
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
                ", reviewID=" + reviewID +
                ", commentText='" + commentText + '\'' +
                ", commentUsername='" + commentUsername + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}