package com.example.voluntariado.repositoriesImp;

import com.example.voluntariado.models.Emergency_Voluntary;
import com.example.voluntariado.models.Voluntary;
import com.example.voluntariado.repositories.Emergency_VoluntaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Emergency_VoluntaryImp implements Emergency_VoluntaryRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Emergency_Voluntary> getAllEmergenciesVoluntaries() {
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM \"emergency_voluntary\"")
                    .executeAndFetch(Emergency_Voluntary.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Emergency_Voluntary> getEmergencyVoluntaryById(Integer id) {
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM emergency_ability WHERE id_emergency_voluntary = :id")
                    .addParameter("id_emergency_voluntary", id)
                    .executeAndFetch(Emergency_Voluntary.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Emergency_Voluntary createEmergencyVoluntary(Emergency_Voluntary emergencyVoluntary) {
        try(Connection connection = sql2o.open()){
            int insertedId = (int) connection
                    .createQuery("INSERT INTO emergency_voluntary (id_emergency, id_voluntary) VALUES (:id_emergency, :id_voluntary)", true)
                    .addParameter("id_emergency", emergencyVoluntary.getId_emergency())
                    .addParameter("id_voluntary", emergencyVoluntary.getId_voluntary())
                    .executeUpdate()
                    .getKey();
            emergencyVoluntary.setId_emergency_voluntary(insertedId);
            return emergencyVoluntary;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean editEmergencyVoluntary(Emergency_Voluntary emergencyVoluntary) {
        try(Connection connection = sql2o.open()){
            connection
                    .createQuery("UPDATE emergency_voluntary SET id_emergency_voluntary = :id_emergency_voluntary, id_emergency =:id_emergency, id_voluntary =:id_voluntary")
                    .addParameter("id_emergency_voluntary", emergencyVoluntary.getId_emergency_voluntary())
                    .addParameter("id_emergency", emergencyVoluntary.getId_emergency())
                    .addParameter("id_voluntary", emergencyVoluntary.getId_voluntary())
                    .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteEmergencyVoluntaryById(Integer id) {
        return false;
    }

    @Override
    public boolean deleteAllEmergenciesVoluntaries() {
        return false;
    }

    @Override
    public List<Voluntary> findVoluntariesByLocationNear(Integer id_emergency, Double distance) {
        return null;
    }
}
