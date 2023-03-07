package br.edu.ufersa.blockbuster.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.blockbuster.domain.entity.Episode;
import br.edu.ufersa.blockbuster.domain.entity.Season;
import br.edu.ufersa.blockbuster.domain.repoitory.EpisodeRepository;

@Service
public class EpisodeService {
    @Autowired
    private EpisodeRepository rep;
    
    public Episode create(Episode ep, Season season){
        ep.setSeason(season);
        rep.save(ep);
        return ep;
    }
}
