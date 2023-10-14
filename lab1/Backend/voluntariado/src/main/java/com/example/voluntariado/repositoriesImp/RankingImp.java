package com.example.voluntariado.repositoriesImp;

import com.example.voluntariado.models.Ranking;
import com.example.voluntariado.repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

/*
* This interface class implements the ranking repository.
* */
@Repository
public class RankingImp implements RankingRepository {
    @Autowired
    private Sql2o sql2o;

    /**
     * This method gets all the rankings from the database.
     * @return List<Ranking>
     * */
    @Override
    public List<Ranking> getAllRankings() {
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM \"ranking\"")
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * This method gets a ranking given an id.
     * @param id
     * @return List<Ranking>
     * */
    @Override
    public List<Ranking> getRankingById(Integer id) {
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM \"ranking\" WHERE id_ranking = :id")
                    .addParameter("id_ranking", id)
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * This method creates a ranking and puts it on the database.
     * @param ranking
     * @return Ranking
     * */
    @Override
    public Ranking createRanking(Ranking ranking) {
        try(Connection connection = sql2o.open()){
            connection
                    .createQuery("INSERT INTO \"ranking\" (id_task, id_voluntary)" +
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

    /**
     * This method edits a ranking and updates it on the database.
     * @param ranking
     * @return Ranking
     * */
    @Override
    public boolean editRanking(Ranking ranking) {
        try(Connection connection = sql2o.open()){
            connection
                    .createQuery("UPDATE \"ranking\" SET id_task = :taskID, id_voluntary = :voluntaryID WHERE id_ranking = :id_ranking")
                    .addParameter("id_ranking", ranking.getId_ranking())
                    .addParameter("taskID", ranking.getId_task())
                    .addParameter("voluntaryID", ranking.getId_voluntary())
                    .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * This method deletes a ranking on the database given an id.
     * @param id
     * @return boolean
     * */
    @Override
    public boolean deleteRankingById(Integer id) {
        int deletedRanking;
        try(Connection connection = sql2o.open()){
            deletedRanking = connection
                    .createQuery("DELETE FROM \"ranking\" WHERE id_ranking = :id")
                    .addParameter("id_ranking", id)
                    .executeUpdate().getResult();
        }
        return deletedRanking == 1;
    }

    /**
     * This method deletes all the rankings on the database.
     * @return boolean
     * */
    @Override
    public boolean deleteAllRankings() {
        try(Connection connection = sql2o.open()){
            connection
                    .createQuery("TRUNCATE \"ranking\" CASCADE")
                    .executeUpdate().getResult();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Ranking> getTopRankingByTaskId(Integer id_task) {
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery(
                            "SELECT va.id_voluntary, " + " ta.id_task, " + "  COUNT(va.id_ability) AS matched_abilities_count " +
                                    "FROM Task_Ability ta " +
                                    "JOIN Voluntary_Ability va ON ta.id_ability = va.id_ability " +
                                    "WHERE ta.id_task = :id_task " +
                                    "GROUP BY va.id_voluntary, ta.id_task " +
                                    "ORDER BY matched_abilities_count DESC, va.id_voluntary")
                    .addParameter("id_task", id_task)
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
