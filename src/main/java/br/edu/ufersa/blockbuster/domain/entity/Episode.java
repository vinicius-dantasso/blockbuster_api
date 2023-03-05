package br.edu.ufersa.blockbuster.domain.entity;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class Episode {

  @NotBlank(message = "Title not null")
  private String title;
  @Size(min = 0, message = "Duration not null")
  private Long duration;
  private LocalDate releaseDate;
  
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
  public String getImageUrl() {
    return imageUrl;
  }
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
