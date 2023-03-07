package br.edu.ufersa.blockbuster.domain.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.blockbuster.domain.entity.Season;

public interface SeasonRepository extends JpaRepository<Season,Long>{
    
}
