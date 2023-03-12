package br.edu.ufersa.blockbuster.domain.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.blockbuster.domain.entity.MinhaLista;
import br.edu.ufersa.blockbuster.domain.entity.User;

public interface MinhaListaRepository extends JpaRepository<MinhaLista, Long>{

    MinhaLista findByUser(User user);
    
}
