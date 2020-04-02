package lv.accenture.bootcamp.rardb4.model;

public class MDetailsMovie {

    private String imdbID;
    private  int movieRating;
    private String title;
    private String poster;

    public MDetailsMovie(String imdbID, int movieRating, String title, String poster) {
        this.imdbID = imdbID;
        this.movieRating = movieRating;
        this.title = title;
        this.poster = poster;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
