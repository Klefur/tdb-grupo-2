package com.example.demo.repositorios;

import com.example.demo.modelos.Ranking;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface RankingRepository {
    public ArrayList<Ranking> getAllRankings();
    public Ranking getRankingById(Integer id);
    public Ranking createRanking(Ranking ranking);
    public Ranking editRanking(Ranking ranking);
    public boolean deleteRankingById(Integer id);
    public boolean deleteAllRankings();
}
