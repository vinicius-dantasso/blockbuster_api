package br.edu.ufersa.blockbuster.api.dto;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.edu.ufersa.blockbuster.domain.entity.AdvisoryRating;
import br.edu.ufersa.blockbuster.domain.entity.Gender;
import br.edu.ufersa.blockbuster.domain.entity.Season;

public class UpdateSerieDto {
    @NotNull(message = "O título não pode ser null")
    private String title;
    @NotNull(message = "A data de lançamento não pode ser null")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String releaseDate;
    @NotNull(message = "O gênero não pode ser null")
    private Gender gender;
    @NotNull(message = "A classificação indicativa não pode ser null")
    private AdvisoryRating advisoryRating;
    @NotNull(message = "A URL da imagem não pode ser null")
    private String imageUrl;
    @NotNull(message = "A serie deve conter seasons")
    private List<Season> seasons;
    private UUID uuid;
    @NotNull(message = "O preço não pode ser null")
    private Double price;

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

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public AdvisoryRating getAdvisoryRating() {
        return this.advisoryRating;
    }

    public void setAdvisoryRating(AdvisoryRating advisoryRating) {
        this.advisoryRating = advisoryRating;
    }

    
}
