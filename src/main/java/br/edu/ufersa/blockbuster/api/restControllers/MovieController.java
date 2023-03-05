package br.edu.ufersa.blockbuster.api.restControllers;

import br.edu.ufersa.blockbuster.api.dto.MovieDto;
import br.edu.ufersa.blockbuster.api.dto.MovieFormDto;
import br.edu.ufersa.blockbuster.api.dto.UpdateMovieDto;
import br.edu.ufersa.blockbuster.domain.entity.Movie;
import br.edu.ufersa.blockbuster.domain.service.MovieService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
	private ModelMapper mapper;
	@Autowired
	private MovieService service;

    @GetMapping
	public List<MovieDto> listar(){
		List<MovieDto> users = new ArrayList<MovieDto>();
		for(Movie movie: service.getAll()) {
			users.add(mapper.map(movie, MovieDto.class));
		}
		return users;
	}
	
	@GetMapping ("/{movieId}")
	public ResponseEntity<MovieDto> buscar(@PathVariable UUID movieId){
		MovieDto dto = mapper.map(service.getByUuid(movieId), MovieDto.class);
		if(dto != null) {
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<MovieDto> criar(@Valid @RequestBody MovieFormDto dto){
		Movie movie = service.createMovie(mapper.map(dto, Movie.class));
		MovieDto criado = mapper.map(movie, MovieDto.class);
		if(criado!=null) {
            return new ResponseEntity<>(criado,HttpStatus.CREATED);
		}
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping
	public ResponseEntity<MovieDto> alterar(@Valid @RequestBody UpdateMovieDto dto){
		Movie movie = service.updateMovie(mapper.map(dto,Movie.class));
		MovieDto atualizado = mapper.map(movie, MovieDto.class);
		if(atualizado!=null) {
			return new ResponseEntity<>(atualizado,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}

    @DeleteMapping("/{userId}")
	public ResponseEntity<UUID> deletar(@PathVariable UUID userId){
		String teste = service.deleteMovie(userId);
		if(teste.equals("ok")) {
			return new ResponseEntity<>(userId,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
