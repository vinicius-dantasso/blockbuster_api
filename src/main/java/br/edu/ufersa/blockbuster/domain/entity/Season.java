package br.edu.ufersa.blockbuster.domain.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "season")
public class Season {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private int seasonNumber;
  @ManyToMany
  @JoinColumn(nullable = false, name = "season_episode")
  private List<Episode> episodes;
  @Column(nullable = false)
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate releaseDate;


  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public int getSeasonNumber() {
    return seasonNumber;
  }
  public void setSeasonNumber(int seasonNumber) {
    this.seasonNumber = seasonNumber;
  }

  public LocalDate getReleaseDate() {
    return releaseDate;
  }
  public void setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
  }
  public List<Episode> getEpisodes() {
    return episodes;
  }
  public void setEpisodes(List<Episode> episodes) {
    this.episodes = episodes;
  }

  
}
