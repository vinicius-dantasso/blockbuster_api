package br.edu.ufersa.blockbuster.domain.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.blockbuster.domain.entity.Season;
import br.edu.ufersa.blockbuster.domain.entity.Serie;

public interface SeasonRepository extends JpaRepository<Season,Long>{

    Season findBySerie(Serie serie);
    
}
