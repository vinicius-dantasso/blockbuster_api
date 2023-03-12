package br.edu.ufersa.blockbuster.api.dto;

import java.util.List;

public class MinhaListaSerie {
    private String email;
    private List<String> serieTitle;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSerieTitle() {
        return this.serieTitle;
    }

    public void setSerieTitle(List<String> serieTitle) {
        this.serieTitle = serieTitle;
    }

}
