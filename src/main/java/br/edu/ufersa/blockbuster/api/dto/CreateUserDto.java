package br.edu.ufersa.blockbuster.api.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CreateUserDto {
    @NotBlank(message="email não pode ser null")
	@Email(message="o email deve ser válido")
	private String email;
	@Size(min=8,message="A senha deve ter pelo menos 8 caracteres")
	@NotNull
	private String senha;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate nascimento;

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

}
