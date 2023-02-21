package br.edu.ufersa.blockbuster.api.dto;

import br.edu.ufersa.blockbuster.domain.entity.AdvisoryRating;
import br.edu.ufersa.blockbuster.domain.entity.Gender;

import java.time.LocalDate;
import java.util.UUID;

public class MovieFormDto {
    private String title;
    private Long duration;
    private LocalDate releaseDate;
    private Gender gender;
    private AdvisoryRating advisoryRating;
    private String imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
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
}
