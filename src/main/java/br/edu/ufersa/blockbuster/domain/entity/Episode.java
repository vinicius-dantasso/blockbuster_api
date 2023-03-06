package br.edu.ufersa.blockbuster.domain.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Episode {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Title not null")
  private String title;
  @NotBlank(message = "Duration not null")
  private Long duration;
  private LocalDate releaseDate;
  
  private String imageUrl;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

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
