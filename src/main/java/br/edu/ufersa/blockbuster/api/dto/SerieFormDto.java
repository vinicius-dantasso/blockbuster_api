package br.edu.ufersa.blockbuster.api.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.edu.ufersa.blockbuster.domain.entity.AdvisoryRating;
import br.edu.ufersa.blockbuster.domain.entity.Gender;
import br.edu.ufersa.blockbuster.domain.entity.Season;

public class SerieFormDto {
    @NotNull(message = "O título não pode ser null")
    private String title;
    @NotNull(message = "A data de lançamento não pode ser null")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate releaseDate;
    @NotNull(message = "O gênero não pode ser null")
    private Gender gender;
    @NotNull(message = "A classificação indicativa não pode ser null")
    private AdvisoryRating advisoryRating;
    @NotNull(message = "A URL da imagem não pode ser null")
    private String imageUrl;
    @NotNull(message = "A serie deve ter pelo menos 1 season")
    private List<Season> seasons;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public AdvisoryRating getAdvisoryRating() {
        return advisoryRating;
    }

    public void setAdvisoryRating(AdvisoryRating advisoryRating) {
        this.advisoryRating = advisoryRating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }
}
