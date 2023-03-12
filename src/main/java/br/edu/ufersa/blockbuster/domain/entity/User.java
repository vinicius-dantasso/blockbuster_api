package br.edu.ufersa.blockbuster.domain.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Entity
@Table(name="user")
public class User {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true,nullable=false)
	private String email;
	@Column(nullable=false)
	private String senha;
    @Column(nullable=false)
    private LocalDate nascimento;
	@Column(updatable=false,nullable=false,columnDefinition="VARCHAR(36)")
	@Type(type="uuid-char")
	private UUID uuid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lista_id",referencedColumnName = "id")
    private MinhaLista lista;

    @Transient
    private List<String> movieTitle;
    @Transient
    private List<String> serieTitle;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getNascimento() {
        return this.nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public MinhaLista getLista() {
        return this.lista;
    }

    public void setLista(MinhaLista lista) {
        this.lista = lista;
    }

    public List<String> getMovieTitle() {
        return this.movieTitle;
    }

    public void setMovieTitle(List<String> movieTitle) {
        this.movieTitle = movieTitle;
    }

    public List<String> getSerieTitle() {
        return this.serieTitle;
    }

    public void setSerieTitle(List<String> serieTitle) {
        this.serieTitle = serieTitle;
    }

}
