package lv.accenture.bootcamp.rardb4.MovieAPI;

import com.google.gson.Gson;
import lv.accenture.bootcamp.rardb4.model.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Component
public class MovieAPIService {

    @Value("${movie.api.request}")
    private String requestURL;


    private String prepareKeyword(String keyword){
        keyword = keyword.trim();
        String modifiedKeyword = keyword.replaceAll(" ", "_");

        return modifiedKeyword;
    }



    public Movie getMovieByID(String idMovie) {

        try {

            URL url = new URL("http://www.omdbapi.com/?apikey=1d075b0b&i=" + idMovie);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(3000);
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
            }
            String JsonResponse = sb.toString();
            bufferedReader.close();

            Gson gson = new Gson();

            Movie movie = gson.fromJson(JsonResponse, Movie.class);
            //String title = movieAPIresponse.getSearch().get(1).getTitle();
            //List<Movie> movieList = movieAPIresponse.getSearch();
            return movie;

        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    public List<Movie> getMovie(String keyword) {

        String requestedKeyword = prepareKeyword(keyword);

        try {

            URL url = new URL(requestURL + requestedKeyword);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(3000);
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
            }
            String JsonResponse = sb.toString();
            bufferedReader.close();

            Gson gson = new Gson();

            MovieAPIResponse movieAPIresponse = gson.fromJson(JsonResponse, MovieAPIResponse.class);
            //String title = movieAPIresponse.getSearch().get(1).getTitle();
            List<Movie> movieList = movieAPIresponse.getSearch();
            return movieList;

        } catch (Exception e) {
            throw new RuntimeException();
        }

    }


}
