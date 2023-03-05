package br.edu.ufersa.blockbuster.domain.repoitory;

import br.edu.ufersa.blockbuster.domain.entity.Serie;
import br.edu.ufersa.blockbuster.domain.entity.AdvisoryRating;
import br.edu.ufersa.blockbuster.domain.entity.Gender;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SerieRepository extends JpaRepository<Serie, Long> {
  Serie findByUuid(UUID uuid);
  Serie findByTitle(String title);
  List<Serie> findByAdvisoryRating(AdvisoryRating advisoryRating);
  List<Serie> findByGender(Gender gender);
}