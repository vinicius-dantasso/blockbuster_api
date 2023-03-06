package br.edu.ufersa.blockbuster.domain.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Season {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NotBlank(message = "Label not null")
  private Integer label;
  @ElementCollection
  private List<Episode> episodes;
  private LocalDate releaseDate;

  public LocalDate getReleaseDate() {
    return releaseDate;
  }
  public void setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
  }
  public Integer getLabel() {
    return label;
  }
  public void setLabel(Integer label) {
    this.label = label;
  }
  public List<Episode> getEpisodes() {
    return episodes;
  }
  public void setEpisodes(List<Episode> episodes) {
    this.episodes = episodes;
  }

  
}
