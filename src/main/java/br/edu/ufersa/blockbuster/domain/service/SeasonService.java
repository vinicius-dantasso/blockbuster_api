package br.edu.ufersa.blockbuster.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.blockbuster.domain.entity.Season;
import br.edu.ufersa.blockbuster.domain.entity.Serie;
import br.edu.ufersa.blockbuster.domain.repoitory.SeasonRepository;

@Service
public class SeasonService {
    @Autowired
    private SeasonRepository rep;

    public Season create(Season season, Serie serie){
        season.setSerie(serie);
        rep.save(season);
        return season;
    }
}
