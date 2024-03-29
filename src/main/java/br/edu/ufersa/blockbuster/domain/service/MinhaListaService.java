package br.edu.ufersa.blockbuster.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.blockbuster.domain.entity.MinhaLista;
import br.edu.ufersa.blockbuster.domain.entity.Movie;
import br.edu.ufersa.blockbuster.domain.entity.Serie;
import br.edu.ufersa.blockbuster.domain.entity.User;
import br.edu.ufersa.blockbuster.domain.repoitory.MinhaListaRepository;

@Service
public class MinhaListaService {
    @Autowired
    private MinhaListaRepository repository;
    @Autowired
    private MovieService movieService;
    @Autowired
    private SerieService serieService;
    @Autowired
    private UserService userService;

    public List <MinhaLista> getAll(){
        List <MinhaLista> minhaLista = repository.findAll();

        return minhaLista;
    }

    public MinhaLista create(User user){
        MinhaLista lista = new MinhaLista();
        lista.setUser(user);
        lista = repository.save(lista);
        return lista;
    }

    public MinhaLista addMovie(User user){
        MinhaLista lista = user.getLista();
        List<String> titles = user.getMovieTitle();
        List<Movie> movies = lista.getMovie();
        boolean canAdd = true;

        for(int i=0;i<titles.size();i++){
            for(int j=0; j<movies.size();j++){
                if(titles.get(i).equals(movies.get(j).getTitle())){
                    canAdd = false;
                }
            }
            if(canAdd){
                movies.add(movieService.getByTitle(titles.get(i)));
            }
            canAdd = true;
        }
        lista.setMovie(movies);
        repository.save(lista);
        return lista;
    }

    public MinhaLista addSerie(User user){
        MinhaLista lista = user.getLista();
        List<String> titles = user.getSerieTitle();
        List<Serie> series = lista.getSerie();
        boolean canAdd = true;

        for(int i=0;i<titles.size();i++){
            for(int j=0;j<series.size();j++){
                if(titles.get(i).equals(series.get(i).getTitle())){
                    canAdd = false;
                }
            }
            if(canAdd){
                series.add(serieService.getByTitle(titles.get(i)));
            }
            canAdd = true;
        }

        lista.setSerie(series);
        repository.save(lista);
        return lista;
    }

    public void deleteMovieFromList(Movie movie){
        List<User> users = userService.getAll();
        Movie movieToRemove = movie;

        for(int i=0;i<users.size();i++){
            User user = users.get(i);
            MinhaLista list = user.getLista();
            List<Movie> movies = list.getMovie();

            for(int j=0;j<movies.size();j++){
                if(movieToRemove.getTitle().equals(movies.get(j).getTitle())){
                    movies.remove(j);
                }
            }

            list.setMovie(movies);
            repository.save(list);
        }
    }

    public void deleteSerieFromList(Serie serie){
        List<User> users = userService.getAll();
        Serie serieToRemove = serie;

        for(int i=0;i<users.size();i++){
            User user = users.get(i);
            MinhaLista lista = user.getLista();
            List<Serie> series = lista.getSerie();

            for(int j=0;j<series.size();j++){
                if(serieToRemove.getTitle().equals(series.get(j).getTitle())){
                    series.remove(j);
                }
            }

            lista.setSerie(series);
            repository.save(lista);
        }
    }
    
}
