package br.edu.ufersa.blockbuster.domain.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.blockbuster.domain.entity.Episode;
import br.edu.ufersa.blockbuster.domain.entity.Season;

public interface EpisodeRepository extends JpaRepository<Episode,Long>{

    Episode findBySeason(Season season);
    
}
