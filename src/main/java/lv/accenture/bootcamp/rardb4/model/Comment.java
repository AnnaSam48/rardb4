package lv.accenture.bootcamp.rardb4.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Comment implements Serializable {

    //TODO : Class is already called Comment, therefore no need to put it in name of inner fields
    // (e.g commentID, commentText etc...)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentID;
    private Long reviewID;

    //TODO: Simple paragraph of text makes MysqlDataTruncation: Data truncation: Data too long for column 'review_text' at row 1 Exception
    private String commentText;
    private String commentUsername;

    //TODO: it's not best practise to keep date/time in String (Think about timezones & user-preferred formats)
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