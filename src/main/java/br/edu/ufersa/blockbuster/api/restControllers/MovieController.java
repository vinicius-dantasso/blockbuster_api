package br.edu.ufersa.blockbuster.api.restControllers;

import br.edu.ufersa.blockbuster.api.dto.MovieDto;
import br.edu.ufersa.blockbuster.api.dto.MovieFormDto;
import br.edu.ufersa.blockbuster.domain.entity.Movie;
import br.edu.ufersa.blockbuster.domain.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<MovieDto> create(MovieFormDto dto) {
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
        MovieDto dto = mapper.map(movie, MovieDto.class);

        if (dto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        Movie movie = movieService.getById(id);
        movieService.delete(movie);
        return ResponseEntity.ok().build();
    }
}
