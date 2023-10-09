package com.example.voluntariado.repositoriesImp;

import com.example.voluntariado.models.Emergency_Ability;
import com.example.voluntariado.repositories.Emergency_AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

/*
* This interface class implements the emergency_ability repository.
* */
@Repository
public class Emergency_AbilityImp implements Emergency_AbilityRepository {
    @Autowired
    private Sql2o sql2o;

    /**
     * This method gets all the emergencies with abilities of the database.
     * @return List<Emergency_Ability>
     * */
    @Override
    public List<Emergency_Ability> getAllEmergenciesAbilities() {
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM \"Emergency_Ability\"")
                    .executeAndFetch(Emergency_Ability.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * This method gets all the emergencies with abilities given an id.
     * @param id
     * @return List<Emergency_Ability>
     * */
    @Override
    public List<Emergency_Ability> getEmergencyAbilityById(Integer id) {
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM \"Emergency_Ability\" WHERE id_emergency_ability =:id")
                    .addParameter("id_emergency_ability", id)
                    .executeAndFetch(Emergency_Ability.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * This method creates an emergency with an ability and puts it on the database, given an emergencyAbility.
     * @param emergencyAbility
     * @return Emergency_Ability
     * */
    @Override
    public Emergency_Ability createEmergencyAbility(Emergency_Ability emergencyAbility) {
        try(Connection connection = sql2o.open()){
            connection
                    .createQuery("INSERT INTO \"Emergency_Ability\" (id_emergency, id_ability) "
                    + "VALUES (:id_emergency, :id_ability)")
                    .addParameter("id_emergency", emergencyAbility.getId_emergency())
                    .addParameter("id_ability", emergencyAbility.getId_ability())
                    .executeUpdate().getKey();
            return emergencyAbility;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * This method edits an emergency with an ability and puts it on the database, given an emergencyAbility.
     * @param emergencyAbility
     * @return boolean
     * */
    @Override
    public boolean editEmergencyAbility(Emergency_Ability emergencyAbility) {
        try(Connection connection = sql2o.open()){
            connection
                    .createQuery("UPDATE \"Emergency_Ability\" SET id_emergency =:id_emergency, id_ability =:id_ability WHERE id_emergency_ability =: id_emergency_ability")
                    .addParameter("id_emergency", emergencyAbility.getId_emergency())
                    .addParameter("id_ability", emergencyAbility.getId_ability())
                    .executeUpdate().getKey();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * This method deletes an emergency with an ability given an id.
     * @param id
     * @return boolean
     * */
    @Override
    public boolean deleteEmergencyAbilityById(Integer id) {
        int deletedEmergencyAbility;
        try(Connection connection = sql2o.open()){
            deletedEmergencyAbility = connection
                    .createQuery("DELETE FROM \"Emergency_Ability\" WHERE id_emergency_ability =:id")
                    .addParameter("id_emergency_ability", id)
                    .executeUpdate().getResult();
        }
        return deletedEmergencyAbility == 1;
    }

    /**
     * This method deletes all the emergencies with abilities on the database.
     * @return boolean
     * */
    @Override
    public boolean deleteAllEmergenciesAbilities() {
        try(Connection connection = sql2o.open()){
            connection
                    .createQuery("TRUNCATE \"Emergency_Ability\" CASCADE")
                    .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
