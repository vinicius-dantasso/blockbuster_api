package br.edu.ufersa.blockbuster.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.blockbuster.domain.entity.Season;
import br.edu.ufersa.blockbuster.domain.entity.Serie;
import br.edu.ufersa.blockbuster.domain.repoitory.SeasonRepository;

@Service
public class SeasonService {
    @Autowired
    private SeasonRepository rep;
    @Autowired
    private EpisodeService episodeService;

    public Season create(Season season, Serie serie){
        season.setSerie(serie);
        rep.save(season);
        return season;
    }

    public void delete(Serie serie){
        List<Season> seasons = serie.getSeasons();
        for(int i=0;i<seasons.size();i++){
            episodeService.delete(seasons.get(i));
            rep.delete(seasons.get(i));
        }
    }
}
