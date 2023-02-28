package br.edu.ufersa.blockbuster.domain.service;

import br.edu.ufersa.blockbuster.domain.entity.Movie;
import br.edu.ufersa.blockbuster.domain.repoitory.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovieService {

    private MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Movie create(Movie movie) {
        return repository.save(movie);
    }

    public List<Movie> getAll() {
        return repository.findAll();
    }

    public Movie getById(UUID id) {
        return repository.findByUuid(id);
    }

    public Movie update(Movie movie) {
        Movie savedMovie = repository.findByUuid(movie.getUuid());
        movie.setId(savedMovie.getId());
        return repository.save(movie);
    }

    public void delete(Movie movie) {
        repository.delete(movie);
    }
}
