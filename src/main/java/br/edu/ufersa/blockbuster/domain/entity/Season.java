package br.edu.ufersa.blockbuster.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "seasons")
public class Season {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(nullable = false)
  private int seasonNumber;

  @OneToMany(mappedBy = "season", cascade = CascadeType.ALL)
  private List<Episode> episodes;

  @ManyToOne
  @JoinColumn(name="serie_id", referencedColumnName = "id")
  private Serie serie;

  public Long getId() {
    return this.id;
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

  public List<Episode> getEpisodes() {
    return episodes;
  }
  public void setEpisodes(List<Episode> episodes) {
    this.episodes = episodes;
  }

  public Serie getSerie() {
    return this.serie;
  }

  public void setSerie(Serie serie) {
    this.serie = serie;
  }
  
}
