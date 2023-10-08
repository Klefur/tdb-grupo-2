package com.example.voluntariado.repositories;

import com.example.voluntariado.models.Ranking;

import java.util.List;

/*
 * This interface class represents the ranking repository.
 * */
public interface RankingRepository {
    public List<Ranking> getAllRankings();
    public List<Ranking> getRankingById(Integer id);
    public Ranking createRanking(Ranking ranking);
    public Ranking editRanking(Ranking ranking);
    public boolean deleteRankingById(Integer id);
    public boolean deleteAllRankings();
}
