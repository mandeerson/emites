package br.com.reips.emites.model;

import java.time.Instant;
import java.util.List;

import br.com.reips.emites.scrapper.Movie;

public class Search implements Comparable<Search> {

    private String query;
    private List<Movie> movies;
    private Instant date = Instant.now();

    public Search(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    @Override
    public int compareTo(Search o) {
        return date.compareTo(o.date);
    }

}
