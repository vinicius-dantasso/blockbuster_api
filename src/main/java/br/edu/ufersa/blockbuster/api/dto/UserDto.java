package br.edu.ufersa.blockbuster.api.dto;

import java.time.LocalDate;
import java.util.UUID;

public class UserDto {
    private String email;
    private LocalDate nascimento;
    private UUID uuid;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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

}
