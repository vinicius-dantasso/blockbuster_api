package br.edu.ufersa.blockbuster.domain.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.blockbuster.domain.repoitory.SerieRepository;

@Service
public class SerieService {

  @Autowired
  private SerieRepository serieRepository;

  @Autowired
  private ModelMapper mapper;
}
