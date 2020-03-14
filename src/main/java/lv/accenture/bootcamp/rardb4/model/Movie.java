package lv.accenture.bootcamp.rardb4.model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Movie implements Serializable {
  
  @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long movieID;
	private String movieName;
	private int Year;
	
	
	public Movie(Long movieID, String movieName, int year) {
		this.movieID = movieID;
		this.movieName = movieName;
		Year = year;
	}


	public Movie() {
	}
}
