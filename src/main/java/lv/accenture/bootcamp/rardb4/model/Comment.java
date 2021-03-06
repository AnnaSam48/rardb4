package lv.accenture.bootcamp.rardb4.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="commentid")
    private Long id;
    private Long reviewID;

    @Column(name = "comment_text", columnDefinition = "text")
    @Length(max=65535, message = "*Your comment can't be longer than 65,535 characters.")
    private String text;
    @Column(name ="comment_username")
    private String username;
    @CreationTimestamp
    private Timestamp timestamp;


    public Comment() {
    }

    public Comment(Long id, Long reviewID,@Length(max=65535, message = "*Your comment can't be longer than 65,535 characters.") String text, String username, Timestamp timeStamp) {
        this.id = id;
        this.reviewID = reviewID;
        this.text = text;
        this.username = username;
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}