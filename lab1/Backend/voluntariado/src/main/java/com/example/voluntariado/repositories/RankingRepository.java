package com.example.voluntariado.repositories;

import com.example.voluntariado.models.Ranking;

import java.util.List;

public interface RankingRepository {
    public List<Ranking> getAllRankings();
    public Ranking getRankingById(Integer id);
    public Ranking createRanking(Ranking ranking);
    public Ranking editRanking(Ranking ranking);
    public boolean deleteRankingById(Integer id);
    public boolean deleteAllRankings();
}
