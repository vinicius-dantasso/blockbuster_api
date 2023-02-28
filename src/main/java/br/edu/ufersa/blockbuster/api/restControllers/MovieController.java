package br.edu.ufersa.blockbuster.api.restControllers;

import br.edu.ufersa.blockbuster.api.dto.MovieDto;
import br.edu.ufersa.blockbuster.api.dto.MovieFormDto;
import br.edu.ufersa.blockbuster.api.dto.UpdateMovieDto;
import br.edu.ufersa.blockbuster.domain.entity.Movie;
import br.edu.ufersa.blockbuster.domain.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private ModelMapper mapper;
    private MovieService movieService;

    public MovieController(
            ModelMapper mapper,
            MovieService movieService
    ) {
        this.mapper = mapper;
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MovieDto> create(@Valid @RequestBody MovieFormDto dto) {
        Movie movie = movieService.create(mapper.map(dto, Movie.class));

        if (movie == null) {
            return ResponseEntity.internalServerError().build();
        }

        MovieDto created = mapper.map(movie, MovieDto.class);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> list() {
        List<MovieDto> movies = new ArrayList<>();

        for (Movie movie : movieService.getAll()) {
            movies.add(mapper.map(movie, MovieDto.class));
        }

        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable UUID id) {
        Movie movie = movieService.getById(id);

        if (movie == null) {
            return ResponseEntity.notFound().build();
        }

        MovieDto dto = mapper.map(movie, MovieDto.class);

        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<MovieDto> update(@RequestBody UpdateMovieDto dto) {
        Movie movie = movieService.update(mapper.map(dto, Movie.class));
        MovieDto updated = mapper.map(movie, MovieDto.class);

        if (updated == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        Movie movie = movieService.getById(id);

        if (movie == null) {
            return ResponseEntity.ok().build();
        }

        movieService.delete(movie);
        return ResponseEntity.ok().build();
    }
}
