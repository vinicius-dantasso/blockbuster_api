package br.edu.ufersa.blockbuster.api.dto;

import br.edu.ufersa.blockbuster.domain.entity.AdvisoryRating;
import br.edu.ufersa.blockbuster.domain.entity.Gender;

import java.time.LocalDate;
import java.util.UUID;

public class MovieDto {
    private String title;
    private Long duration;
    private LocalDate releaseDate;
    private Gender gender;
    private AdvisoryRating advisoryRating;
    private String imageUrl;
    private UUID uuid;
}
