package br.edu.ufersa.blockbuster.domain.service;

import br.edu.ufersa.blockbuster.domain.entity.Movie;
import br.edu.ufersa.blockbuster.domain.repoitory.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovieService {
    @Autowired
    private MovieRepository rep;
    @Autowired
    private MinhaListaService myListService;

    public List<Movie> getAll(){
        List<Movie> movies = rep.findAll();
        return movies;
    }

    public Movie getByUuid(UUID id){
        Movie movie = rep.findByUuid(id);
        return movie;
    }

    public Movie getByTitle(String title){
        Movie movie = rep.findByTitle(title);
        return movie;
    }

    public Movie createMovie(Movie movie){
        movie.setUuid(UUID.randomUUID());
        rep.save(movie);
        return movie;
    }

    public Movie updateMovie(Movie movie){
        Movie dataMovie = rep.findByUuid(movie.getUuid());
        dataMovie.setTitle(movie.getTitle());
        dataMovie.setDuration(movie.getDuration());
        dataMovie.setGender(movie.getGender());
        dataMovie.setAdvisoryRating(movie.getAdvisoryRating());
        dataMovie.setImageUrl(movie.getImageUrl());
        dataMovie.setReleaseDate(movie.getReleaseDate());
        dataMovie.setPrice(movie.getPrice());
        rep.save(dataMovie);
        return dataMovie;
    }

    public String deleteMovie(UUID id){
        Movie dataMovie = rep.findByUuid(id);
        myListService.deleteMovieFromList(dataMovie);
        if(dataMovie!=null){
            rep.delete(dataMovie);
            return "ok";
        }
        return "Movie not found";
    }
}
