package br.edu.ufersa.blockbuster.domain.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "serie")
public class Season {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Type(type = "uuid-char")
  private UUID uuid;
  @NotBlank(message = "Label not null")
  private Integer label;
  private List<Episode> episodes;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public UUID getUuid() {
    return uuid;
  }
  public void setUuid(UUID uuid) {
    this.uuid = uuid;
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
