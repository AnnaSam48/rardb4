package lv.accenture.bootcamp.rardb4.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie implements Serializable {
  
  @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long movieID;
	private String movieName;
	private Integer Year;
    private String imageUrl;
    private String genre;
    private Double imdbRating;
    private Integer rotTomRating;
    private String plot;
	
	
	public Movie(Long movieID, String movieName, Integer year) {
		this.movieID = movieID;
		this.movieName = movieName;
		Year = year;
	}



	public Movie() {
	}
}
