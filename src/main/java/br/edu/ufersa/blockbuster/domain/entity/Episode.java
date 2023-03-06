package br.edu.ufersa.blockbuster.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "episode")
public class Episode {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
 
  @NotBlank(message = "Title not null")
  @Column(nullable = false)
  private String title;
  @NotBlank(message = "Duration not null")
  @Column(nullable = false)
  private Long duration;
  @Column(nullable = false)
  private int episodeNumber;
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public int getEpisodeNumber() {
    return episodeNumber;
  }
  public void setEpisodeNumber(int episodeNumber) {
    this.episodeNumber = episodeNumber;
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

}
