package br.edu.ufersa.blockbuster.domain.repoitory;

import br.edu.ufersa.blockbuster.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByUuid(UUID uuid);
}
