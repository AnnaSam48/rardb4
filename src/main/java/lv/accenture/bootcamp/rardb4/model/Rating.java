package lv.accenture.bootcamp.rardb4.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Rating implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ratingid")
    private Long id;
    private Long reviewId;
    private int value;
    private String ratedByUser;

    public Rating() {
    }

    public Rating(Long id, Long reviewId, int value, String ratedByUser) {
        this.id = id;
        this.reviewId = reviewId;
        this.value = value;
        this.ratedByUser = ratedByUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getRatedByUser() {
        return ratedByUser;
    }

    public void setRatedByUser(String ratedByUser) {
        this.ratedByUser = ratedByUser;
    }
}
