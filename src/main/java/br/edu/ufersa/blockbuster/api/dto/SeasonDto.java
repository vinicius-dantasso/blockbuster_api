package br.edu.ufersa.blockbuster.api.dto;

import java.util.List;

public class SeasonDto {
    private int seasonNumber;
    private List<EpisodeDto> episodes;

    public int getSeasonNumber() {
        return this.seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public List<EpisodeDto> getEpisodes() {
        return this.episodes;
    }

    public void setEpisodes(List<EpisodeDto> episodes) {
        this.episodes = episodes;
    }

}
