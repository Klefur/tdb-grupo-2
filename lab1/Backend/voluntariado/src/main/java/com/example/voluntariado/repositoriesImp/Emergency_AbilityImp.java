package com.example.voluntariado.repositoriesImp;

import com.example.voluntariado.models.Emergency_Ability;
import com.example.voluntariado.repositories.Emergency_AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Emergency_AbilityImp implements Emergency_AbilityRepository {
    @Autowired
    private Sql2o sql2o;

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

    @Override
    public Emergency_Ability editEmergencyAbility(Emergency_Ability emergencyAbility) {
        try(Connection connection = sql2o.open()){
            connection
                    .createQuery("UPDATE \"Emergency_Ability\" SET id_emergency =:id_emergency, id_ability =:id_ability WHERE id_emergency_ability =: id_emergency_ability")
                    .addParameter("id_emergency", emergencyAbility.getId_emergency())
                    .addParameter("id_ability", emergencyAbility.getId_ability())
                    .executeUpdate().getKey();
            return emergencyAbility;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

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
