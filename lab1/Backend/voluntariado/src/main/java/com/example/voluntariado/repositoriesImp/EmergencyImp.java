package com.example.voluntariado.repositoriesImp;

import com.example.voluntariado.models.Emergency;
import com.example.voluntariado.repositories.EmergencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

/*
* This interface class implements the emergency repository.
* */
@Repository
public class EmergencyImp implements EmergencyRepository {

    @Autowired
    private Sql2o sql2o;
    /**
     * This method gets all the existing emergencies on the database.
     * @return List<Emergency>
     * */
    @Override
    public List<Emergency> getAllEmergencies() {
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM \"Emergency\"")
                    .executeAndFetch(Emergency.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * This method gets an emergency on the database given an id.
     * @param id
     * @return List<Emergency>
     * */
    @Override
    public List<Emergency> getEmergencyById(Integer id) {
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM \"Emergency\" WHERE id_emergency =:id")
                    .executeAndFetch(Emergency.class);
        }catch(Exception e){
            return null;
        }
    }

    /**
     * This method creates an emergency and puts it on the database.
     * @param emergency
     * @return Emergency
     * */
    @Override
    public Emergency createEmergency(Emergency emergency) {
        try(Connection connection = sql2o.open()){
            connection
                    .createQuery("INSERT INTO \"Emergency\" (name, description, state, id_institution)"
                    + "VALUES (:name, :description, :state, :id_institution)")
                    .addParameter("name", emergency.getName())
                    .addParameter("description", emergency.getDescription())
                    .addParameter("state", emergency.getState())
                    .addParameter("id_institution", emergency.getId_institution())
                    .executeUpdate().getKey();
            return emergency;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * This method edits an emergency and updates it on the database.
     * @param emergency
     * @return boolean
     * */
    @Override
    public boolean editEmergency(Emergency emergency) {
        try(Connection connection = sql2o.open()){
            connection
                    .createQuery("UPDATE \"Emergency\" SET name =:name, description =:description, state =:state, id_institution =:id_institution WHERE id_emergency =:id_emergency")
                    .addParameter("name", emergency.getName())
                    .addParameter("description", emergency.getDescription())
                    .addParameter("state", emergency.getState())
                    .addParameter("id_institution", emergency.getId_institution())
                    .executeUpdate().getKey();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * This method deletes an emergency on the database given an id.
     * @param id
     * @return boolean
     * */
    @Override
    public boolean deleteEmergencyById(Integer id) {
        int deletedEmergency;
        try(Connection connection = sql2o.open()){
            deletedEmergency = connection
                    .createQuery("DELETE FROM \"Emergency\" WHERE id_emergency =:id")
                    .addParameter("id_emergency", id)
                    .executeUpdate().getResult();
        }
        return deletedEmergency == 1;
    }

    /**
     * This method deletes all the emergencies on the database.
     * @return boolean
     * */
    @Override
    public boolean deleteAllEmergencies() {
        try(Connection connection = sql2o.open()){
            connection
                    .createQuery("TRUNCATE \"Emergency\" CASCADE")
                    .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
