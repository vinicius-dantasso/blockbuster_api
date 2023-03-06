package br.edu.ufersa.blockbuster.api.restControllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping
  public List<SerieDto> list() {
    List<SerieDto> seriesDto = new ArrayList<SerieDto>();

    for (Serie serie : this.serieService.getAll()) {
      seriesDto.add(this.mapper.map(serie, SerieDto.class));
    }

    return seriesDto;
  }

  @GetMapping("/{id}")
  public ResponseEntity<SerieDto> search(@PathVariable UUID id) {
    SerieDto dto = this.mapper.map(this.serieService.getByUuid(id), SerieDto.class);

    if (dto != null) {
      return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    return ResponseEntity.notFound().build();
  }

  @GetMapping("/{title}")
  public ResponseEntity<SerieDto> search(@PathVariable String title) {
    SerieDto dto = this.mapper.map(this.serieService.getByTitle(title), SerieDto.class);

    if (dto != null) {
      return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    return ResponseEntity.notFound().build();
  }
}
