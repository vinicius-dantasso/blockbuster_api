package br.edu.ufersa.blockbuster.domain.entity;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotBlank;


public class Season {

  @NotBlank(message = "Label not null")
  private Integer label;
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
