package br.edu.ufersa.blockbuster.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.blockbuster.domain.entity.Serie;
import br.edu.ufersa.blockbuster.domain.entity.Gender;
import br.edu.ufersa.blockbuster.domain.entity.Season;
import br.edu.ufersa.blockbuster.domain.entity.AdvisoryRating;
import br.edu.ufersa.blockbuster.domain.entity.Episode;
import br.edu.ufersa.blockbuster.domain.repoitory.SerieRepository;

@Service
public class SerieService {

  @Autowired
  private SerieRepository serieRepository;
  @Autowired
  private SeasonService seasonService;
  @Autowired
  private EpisodeService episodeService;

  public Serie create(Serie serie) {
    serie.setUuid(UUID.randomUUID());
    serie = serieRepository.save(serie);

    List<Season> seasons = serie.getSeasons();
    for(int i=0;i<seasons.size();i++){
      seasonService.create(seasons.get(i), serie);

      List<Episode> episodes = seasons.get(i).getEpisodes();
      for(int j=0;j<episodes.size();j++){
        episodeService.create(episodes.get(j), seasons.get(i));
      }
      
    }

    return serie;
  }

  public List<Serie> getAll() {
    return this.serieRepository.findAll();
  }

  public Serie getByUuid(UUID uuid) {
    return this.serieRepository.findByUuid(uuid);
  }

  public Serie getByTitle(String title) {
    return this.serieRepository.findByTitle(title);
  }

  public List<Serie> getByGender(Gender gender) {
    return this.serieRepository.findByGender(gender);
  }

  public List<Serie> getByAdvisoryRating(AdvisoryRating advisoryRating) {
    return this.serieRepository.findByAdvisoryRating(advisoryRating);
  }

  public Serie update(Serie serie) {
    Serie savedSerie = this.serieRepository.findByUuid(serie.getUuid());
    savedSerie.setSeasons(serie.getSeasons());
    return this.serieRepository.save(savedSerie);
  }

  public void delete(Serie serie) {
    this.serieRepository.delete(serie);
  }
}
