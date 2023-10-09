package com.example.voluntariado.services;

import com.example.voluntariado.models.Ranking;
import com.example.voluntariado.repositories.RankingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RankingService {
    private final RankingRepository rankingRepository;

    public RankingService(RankingRepository rankingRepository){
        this.rankingRepository = rankingRepository;
    }

    @GetMapping("/rankings")
    public List<Ranking> getAllRankings(){
        return rankingRepository.getAllRankings();
    }

    @GetMapping("/rankings/{id_ranking}")
    public List<Ranking> getRankingById(@PathVariable("id_ranking") Integer id_ranking){
        return rankingRepository.getRankingById(id_ranking);
    }

    @PostMapping("/rankings")
    @ResponseBody
    public Ranking createRanking(@RequestBody Ranking ranking){
        return rankingRepository.createRanking(ranking);
    }

    @PutMapping("/rankings/{id_ranking}")
    @ResponseBody
    public String editRanking(@PathVariable("id_ranking") Integer id_ranking, @RequestBody Ranking ranking){
        ranking.setId_ranking(id_ranking);
        boolean result = rankingRepository.editRanking(ranking);
        if(result){
            return "Edited Ranking";
        }else{
            return "Ranking not found";
        }
    }

    @DeleteMapping("/rankings/{id_ranking}")
    @ResponseBody
    public String deleteRankingById(@PathVariable("id_ranking") Integer id_ranking){
        boolean result = rankingRepository.deleteRankingById(id_ranking);
        if(result){
            return "Deleted Ranking";
        }else{
            return "Ranking not found";
        }
    }
}
