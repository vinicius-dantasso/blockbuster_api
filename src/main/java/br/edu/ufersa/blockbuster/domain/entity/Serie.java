package br.edu.ufersa.blockbuster.domain.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "serie")
public class Serie {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
  @Type(type = "uuid-char")
  private UUID uuid;

  @NotBlank(message = "Title not null")
  @Column(nullable = true)
  private String title;
  @Size(min = 0, message = "Duration not 00.00")
  private Long duration;
  @NotBlank(message = "Release Date not null")
  private LocalDate releaseDate;
  @NotBlank(message = "Gender not null")
  private Gender gender;

  @NotBlank(message = "Advisory Rating not null")
  private AdvisoryRating advisoryRating;

  private String imageUrl;
  private List<Season> seasons;

  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public UUID getUuid() {
    return uuid;
  }
  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public long getDuration() {
    return duration;
  }
  public void setDuration(long duration) {
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
  public List<Season> getSeasons() {
    return seasons;
  }
  public void setSeasons(List<Season> seasons) {
    this.seasons = seasons;
  }

  
}
