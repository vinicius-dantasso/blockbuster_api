package br.edu.ufersa.blockbuster.domain.repoitory;

import br.edu.ufersa.blockbuster.domain.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SerieRepository extends JpaRepository<Serie, Long> {
  Serie findByUuid(UUID uuid);
}