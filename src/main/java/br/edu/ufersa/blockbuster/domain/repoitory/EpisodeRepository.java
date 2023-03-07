package br.edu.ufersa.blockbuster.domain.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.blockbuster.domain.entity.Episode;

public interface EpisodeRepository extends JpaRepository<Episode,Long>{
    
}
