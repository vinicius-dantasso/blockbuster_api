package br.edu.ufersa.blockbuster.api.restControllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.blockbuster.domain.entity.Serie;
import br.edu.ufersa.blockbuster.domain.service.SerieService;
import br.edu.ufersa.blockbuster.api.dto.SerieDto;
import br.edu.ufersa.blockbuster.api.dto.SerieFormDto;

@RestController
@RequestMapping("/api/series")
public class SerieController {
  
  @Autowired
  private ModelMapper mapper;

  @Autowired
  private SerieService serieService;

  @PostMapping
  public ResponseEntity<SerieDto> create(@Valid @RequestBody SerieFormDto dto) {
    Serie serie = this.serieService.create(mapper.map(dto, Serie.class));

    if (serie == null) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    SerieDto created = mapper.map(serie, SerieDto.class);
    return new ResponseEntity<>(created, HttpStatus.CREATED);
  }
}
