package br.edu.ufersa.blockbuster.domain.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.blockbuster.domain.entity.MinhaLista;

public interface MinhaListaRepository extends JpaRepository<MinhaLista, Long>{
    
}
