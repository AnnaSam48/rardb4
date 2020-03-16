package lv.accenture.bootcamp.rardb4.MovieAPI;

import lv.accenture.bootcamp.rardb4.model.Movie;

import java.util.List;

public class MovieAPIResponse {

    private List<Movie> Search;

    private String Response;

    public List<Movie> getSearch() {
        return Search;
    }
}
