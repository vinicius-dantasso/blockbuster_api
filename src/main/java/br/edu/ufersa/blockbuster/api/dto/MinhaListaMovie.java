package br.edu.ufersa.blockbuster.api.dto;

import java.util.List;

public class MinhaListaMovie {
    private String email;
    private List<String> movieTitle;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getMovieTitle() {
        return this.movieTitle;
    }

    public void setMovieTitle(List<String> movieTitle) {
        this.movieTitle = movieTitle;
    }

}
