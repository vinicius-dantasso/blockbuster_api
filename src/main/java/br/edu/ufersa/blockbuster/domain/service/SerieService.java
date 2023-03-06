package br.edu.ufersa.blockbuster.domain.service;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.blockbuster.domain.entity.Serie;
import br.edu.ufersa.blockbuster.domain.entity.Gender;
import br.edu.ufersa.blockbuster.domain.entity.AdvisoryRating;
import br.edu.ufersa.blockbuster.domain.repoitory.SerieRepository;

@Service
public class SerieService {

  @Autowired
  private SerieRepository serieRepository;

  @Autowired
  private ModelMapper mapper;

  public Serie create(Serie serie) {
    return this.serieRepository.save(serie);
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
    serie.setId(savedSerie.getId());
    return this.serieRepository.save(serie);
  }

  public void delete(Serie serie) {
    this.serieRepository.delete(serie);
  }
}
