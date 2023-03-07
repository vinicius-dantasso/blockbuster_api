package br.edu.ufersa.blockbuster.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "episodes")
public class Episode {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
 
  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private int duration;
  
  @Column(nullable = false)
  private int episodeNumber;

  @ManyToOne
  @JoinColumn(name = "season_id", referencedColumnName = "id")
  private Season season;
  
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
  public int getDuration() {
    return duration;
  }
  public void setDuration(int duration) {
    this.duration = duration;
  }

  public Season getSeason() {
    return this.season;
  }

  public void setSeason(Season season) {
    this.season = season;
  }

}
