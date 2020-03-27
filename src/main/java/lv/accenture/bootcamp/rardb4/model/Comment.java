package lv.accenture.bootcamp.rardb4.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Comment implements Serializable {

    //TODO : Class is already called Comment, therefore no need to put it in name of inner fields
    // (e.g commentID, commentText etc...) - DONE
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="commentid")
    private Long id;
    private Long reviewID;

    //TODO: Simple paragraph of text makes MysqlDataTruncation: Data truncation: Data too long for column 'review_text' at row 1 Exception
    @Column(name = "comment_text", columnDefinition = "text")// is this fixing TODO??
    private String text;
    @Column(name ="comment_username")
    private String username;

    //TODO: it's not best practise to keep date/time in String (Think about timezones & user-preferred formats)
    private String timestamp;



    public Comment() {
    }

    public Comment(Long id, Long reviewID, String text, String username, String timeStamp) {
        this.id = id;
        this.reviewID = reviewID;
        this.text = text;
        this.username = username;
        this.timestamp = timeStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReviewID() {
        return reviewID;
    }

    public void setReviewID(Long reviewID) {
        this.reviewID = reviewID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}