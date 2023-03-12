package br.edu.ufersa.blockbuster.api.dto;

import java.util.List;

public class MinhaListaDto {
    private List<MovieDto> movie;
    private List<SerieDto> serie;

    public List<MovieDto> getMovie() {
        return this.movie;
    }

    public void setMovie(List<MovieDto> movie) {
        this.movie = movie;
    }

    public List<SerieDto> getSerie() {
        return this.serie;
    }

    public void setSerie(List<SerieDto> serie) {
        this.serie = serie;
    }

}
