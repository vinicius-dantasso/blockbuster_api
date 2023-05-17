package br.edu.ufersa.blockbuster.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.blockbuster.domain.entity.Serie;
import br.edu.ufersa.blockbuster.domain.entity.Gender;
import br.edu.ufersa.blockbuster.domain.entity.Season;
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
  @Autowired
  private MinhaListaService myListService;

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

  public Serie update(Serie serie) {
    //Série salva no banco de dados
    Serie savedSerie = serieRepository.findByUuid(serie.getUuid());

    //Lista das novas temporadas que serão adicionadas
    List<Season> newSeasons = serie.getSeasons();
    for(int i=0;i<newSeasons.size();i++){
      newSeasons.get(i).setSerie(savedSerie);

      //Lista dos novos episódios das novas, respectivas, temporadas
      List<Episode> newEpisodes = newSeasons.get(i).getEpisodes();
      for(int j=0;j<newEpisodes.size();j++){
        newEpisodes.get(j).setSeason(newSeasons.get(i));
      }
    }

    //Adição da nova lista à antiga
    List<Season> updatedSeasons = savedSerie.getSeasons();
    updatedSeasons.addAll(newSeasons);

    savedSerie.setSeasons(updatedSeasons);
    serieRepository.save(savedSerie);
    return savedSerie;
  }

  public String delete(UUID uuid) {
    Serie serie = serieRepository.findByUuid(uuid);
    myListService.deleteSerieFromList(serie);
    if(serie!=null){
      seasonService.delete(serie);
      serieRepository.delete(serie);
      return "ok";
    }
    return "Serie not found";
  }

}
