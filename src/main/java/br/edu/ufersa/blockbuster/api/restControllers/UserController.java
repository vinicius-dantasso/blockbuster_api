package br.edu.ufersa.blockbuster.api.restControllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.blockbuster.api.dto.CreateUserDto;
import br.edu.ufersa.blockbuster.api.dto.MinhaListaAddMovie;
import br.edu.ufersa.blockbuster.api.dto.MinhaListaAddSerie;
import br.edu.ufersa.blockbuster.api.dto.UpdateUserDto;
import br.edu.ufersa.blockbuster.api.dto.UserDto;
import br.edu.ufersa.blockbuster.domain.entity.User;
import br.edu.ufersa.blockbuster.domain.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
	private ModelMapper mapper;
	@Autowired
	private UserService service;
	
	@GetMapping
	public List<UserDto> listar(){
		List<UserDto> users = new ArrayList<UserDto>();
		for(User user: service.getAll()) {
			users.add(mapper.map(user, UserDto.class));
		}
		return users;
	}
	
	@GetMapping ("/{userId}")
	public ResponseEntity<UserDto> buscar(@PathVariable UUID userId){
		UserDto dto = mapper.map(service.getById(userId), UserDto.class);
		if(dto != null) {
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<UserDto> criar(@Valid @RequestBody CreateUserDto dto){
		User user = service.createUser(mapper.map(dto, User.class));
		UserDto criado = mapper.map(user, UserDto.class);
		
		if(criado == null) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			return new ResponseEntity<>(criado,HttpStatus.CREATED);
		}
	}

	@PutMapping
	public ResponseEntity<UserDto> alterar(@Valid @RequestBody UpdateUserDto dto){
		User user = service.updateUser(mapper.map(dto,User.class));
		UserDto atualizado = mapper.map(user, UserDto.class);
		
		if(atualizado!=null) {
			return new ResponseEntity<>(atualizado,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping
	public ResponseEntity<UserDto> atualizarTudo(@Valid @RequestBody CreateUserDto dto){
		User user = service.updateUserPatch(mapper.map(dto, User.class));
		UserDto atualizado = mapper.map(user, UserDto.class);
		
		if(atualizado!=null) {
			return new ResponseEntity<>(atualizado,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PatchMapping("/my_list/movies")
	public ResponseEntity<UserDto> inserirMovie(@Valid @RequestBody MinhaListaAddMovie dto){
		User user = service.updateMovieList(mapper.map(dto, User.class));
		UserDto atualizado = mapper.map(user, UserDto.class);
		if(atualizado!=null){
			return new ResponseEntity<>(atualizado,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PatchMapping("/my_list/series")
	public ResponseEntity<UserDto> inserirSerie(@Valid @RequestBody MinhaListaAddSerie dto){
		User user = service.updateSerieList(mapper.map(dto, User.class));
		UserDto atualizado = mapper.map(user, UserDto.class);
		if(atualizado!=null){
			return new ResponseEntity<>(atualizado,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<UUID> deletar(@PathVariable UUID userId){
		String teste = service.deleteUser(userId);
		
		if(teste.equals("ok")) {
			return new ResponseEntity<>(userId,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
