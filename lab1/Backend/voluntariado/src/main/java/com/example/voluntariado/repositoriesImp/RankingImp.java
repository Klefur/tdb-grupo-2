package com.example.voluntariado.repositoriesImp;

import com.example.voluntariado.models.Ranking;
import com.example.voluntariado.repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class RankingImp implements RankingRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Ranking> getAllRankings() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Ranking\"")
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Ranking> getRankingById(Integer id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Ranking\" WHERE id_ranking = :id")
                    .addParameter("id_ranking", id)
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Ranking createRanking(Ranking ranking) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO \"Ranking\" (id_task, id_voluntary)" +
                            "values (:taskID, :voluntaryID)")
                    .addParameter("taskID", ranking.getId_task())
                    .addParameter("voluntaryID", ranking.getId_voluntary())
                    .executeUpdate().getKey();
            return ranking;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Ranking editRanking(Ranking ranking) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE \"Ranking\" SET id_task = :taskID, id_voluntary = :voluntaryID WHERE id_ranking = :id_ranking")
                    .addParameter("id_ranking", ranking.getId_ranking())
                    .addParameter("taskID", ranking.getId_task())
                    .addParameter("voluntaryID", ranking.getId_voluntary())
                    .executeUpdate();
            return ranking;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteRankingById(Integer id) {
        int deletedRanking;
        try(Connection conn = sql2o.open()){
            deletedRanking = conn.createQuery("DELETE FROM \"Ranking\" WHERE id_ranking = :id")
                    .addParameter("id_ranking", id)
                    .executeUpdate().getResult();
        }
        return deletedRanking == 1;
    }

    @Override
    public boolean deleteAllRankings() {
        try(Connection conn = sql2o.open()){
            conn.createQuery("TRUNCATE \"Ranking\" CASCADE")
                    .executeUpdate().getResult();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
