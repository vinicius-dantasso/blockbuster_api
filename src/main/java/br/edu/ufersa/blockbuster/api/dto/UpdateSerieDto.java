package br.edu.ufersa.blockbuster.api.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import br.edu.ufersa.blockbuster.domain.entity.Season;

public class UpdateSerieDto {
  @NotNull(message = "A URL da imagem não pode ser null")
  private String imageUrl;
  @NotNull(message = "A serie deve conter seasons")
  private List<Season> seasons;

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
