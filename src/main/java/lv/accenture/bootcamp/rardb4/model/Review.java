package lv.accenture.bootcamp.rardb4.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review implements Serializable {


	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)

	    private Long reviewID;
   		private String comment;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getReviewID() {
		return reviewID;
	}

	public void setReviewID(Long reviewID) {
		this.reviewID = reviewID;
	}


}
