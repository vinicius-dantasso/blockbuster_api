package br.edu.ufersa.blockbuster.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.ufersa.blockbuster.domain.entity.MinhaLista;
import br.edu.ufersa.blockbuster.domain.entity.User;
import br.edu.ufersa.blockbuster.domain.repoitory.UserRepository;

@Service
public class UserService {
    @Autowired
	private UserRepository rep;
	@Autowired
	private MinhaListaService minhaListaService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> getAll(){
		List<User> users = rep.findAll();
		return users;
	}
	
	public User getById(UUID id) {
		User user = rep.findByUuid(id);
		return user;
	}

	public User getByEmail(String email){
		User user = rep.findByEmail(email);
		return user;
	}
	
	public User createUser(User user) {
		user.setUuid(UUID.randomUUID());
		user.setSenha(passwordEncoder.encode(user.getSenha()));
		user = rep.save(user);
		MinhaLista lista = minhaListaService.create(user);
		user.setLista(lista);
		rep.save(user);
		return user;
	}
	
	public User updateUser(User user) {
		User dataUser = rep.findByUuid(user.getUuid());
		dataUser.setSenha(user.getSenha());
		rep.save(dataUser);
		return dataUser;
	}
	
	public String deleteUser(UUID uuid) {
		User dataUser = rep.findByUuid(uuid);
		if(dataUser!=null) {
			rep.delete(dataUser);
			return "ok";
		}
		return "User not Found";
	}
	
	public User updateUserPatch(User user) {
		User dataUser = rep.findByEmail(user.getEmail());
		dataUser.setSenha(user.getSenha());
		rep.save(dataUser);
		return dataUser;
	}

	public User addMovie(User user){
		User dataUser = rep.findByEmail(user.getEmail());
		dataUser.setMovieTitle(user.getMovieTitle());

		MinhaLista lista = dataUser.getLista();
		lista = minhaListaService.addMovie(dataUser);

		dataUser.setLista(lista);
		rep.save(dataUser);
		return dataUser;
	}

	public User addSerie(User user){
		User dataUser = rep.findByEmail(user.getEmail());
		dataUser.setSerieTitle(user.getSerieTitle());

		MinhaLista lista = dataUser.getLista();
		lista = minhaListaService.addSerie(dataUser);

		dataUser.setLista(lista);
		rep.save(dataUser);
		return dataUser;
	}
}
