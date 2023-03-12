package br.edu.ufersa.blockbuster.api.dto;

import br.edu.ufersa.blockbuster.domain.entity.AdvisoryRating;
import br.edu.ufersa.blockbuster.domain.entity.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

public class UpdateMovieDto {
    @NotNull(message = "O título não pode ser null")
    private String title;
    @NotNull(message = "A duração não pode ser null")
    private Long duration;
    @NotNull(message = "A data de lançamento não pode ser null")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate releaseDate;
    @NotNull(message = "O gênero não pode ser null")
    private Gender gender;
    @NotNull(message = "A classificação indicativa não pode ser null")
    private AdvisoryRating advisoryRating;
    @NotNull(message = "A URL da imagem não pode ser null")
    private String imageUrl;
    private UUID uuid;
    @NotNull(message = "O Preço não pose ser null")
    private Double price;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getDuration() {
        return this.duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
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

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    
    
}
