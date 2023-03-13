package br.edu.ufersa.blockbuster.domain.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "serie")
public class Serie {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  @Column(updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
  @Type(type = "uuid-char")
  private UUID uuid;

  @Column(nullable = true)
  private String title;
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate releaseDate;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Gender gender;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private AdvisoryRating advisoryRating;

  @Column(nullable = false)
  private String imageUrl;

  @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
  private List<Season> seasons;

  @ManyToMany(mappedBy = "serie")
  private List<MinhaLista> lista;

  @Column(nullable = false)
  private Double price;

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
  public List<MinhaLista> getLista() {
    return lista;
  }
  public void setLista(List<MinhaLista> lista) {
    this.lista = lista;
  }
  public Double getPrice() {
    return price;
  }
  public void setPrice(Double price) {
    this.price = price;
  }

  
}
