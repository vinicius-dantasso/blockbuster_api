package br.edu.ufersa.blockbuster.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.blockbuster.domain.entity.MinhaLista;
import br.edu.ufersa.blockbuster.domain.entity.Movie;
import br.edu.ufersa.blockbuster.domain.entity.Serie;
import br.edu.ufersa.blockbuster.domain.repoitory.MinhaListaRepository;

@Service
public class MinhaListaService {
    @Autowired
    private MinhaListaRepository repository;

    public List <MinhaLista> getAll(){
        List <MinhaLista> minhaLista = repository.findAll();

        return minhaLista;
    }

    public MinhaLista create(Movie movie, Serie serie, MinhaLista lista){
        movie.setLista(lista);
        serie.setLista(lista);
        repository.save(lista);

        return lista;
    }
    
}
