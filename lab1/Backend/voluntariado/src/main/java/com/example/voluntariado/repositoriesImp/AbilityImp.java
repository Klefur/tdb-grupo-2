package com.example.voluntariado.repositoriesImp;

import com.example.voluntariado.models.Ability;
import com.example.voluntariado.repositories.AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class AbilityImp implements AbilityRepository {

    @Autowired
    private Sql2o sql2o;

    /**
     * This method gets all the abilities from the database.
     * @return List<Ability>
     * */
    @Override
    public List<Ability> getAllAbilities() {
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM \"Ability\"")
                    .executeAndFetch(Ability.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * This method gets all the abilities with a specific id.
     * @param id
     * @return List<Ability>
     * */
    @Override
    public List<Ability> getAbilityById(Integer id) {
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM \"Ability\" WHERE id_ability =:id")
                    .addParameter("id_ability", id)
                    .executeAndFetch(Ability.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * This method receives an ability object and inserts it to the database.
     * @param ability
     * @return Ability
     * */
    @Override
    public Ability createAbility(Ability ability) {
        try(Connection connection = sql2o.open()){
            connection
                    .createQuery("INSERT INTO \"Ability\" (names, description, items) "
                            + "VALUES (:names, :description, :items)")
                    .addParameter("names", ability.getNames())
                    .addParameter("description", ability.getDescription())
                    .addParameter("items", ability.getItems())
                    .executeUpdate().getKey();
            return ability;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * This method receives an ability object and updates it to the database.
     * @param ability
     * @return Ability
     * */
    @Override
    public Ability editAbility(Ability ability) {
        try(Connection connection = sql2o.open()){
            connection
                    .createQuery("UPDATE \"Ability\" SET names =:names, description =:description, items =:items WHERE id_ability =:id_ability")
                    .addParameter("names", ability.getNames())
                    .addParameter("description", ability.getDescription())
                    .addParameter("items", ability.getItems())
                    .executeUpdate().getKey();
            return ability;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * This method deletes an ability given an id.
     * @param id
     * @return boolean
     * */
    @Override
    public boolean deleteAbilityById(Integer id) {
        int deletedAbility;
        try(Connection connection = sql2o.open()){
            deletedAbility = connection
                    .createQuery("DELETE FROM \"Ability\" WHERE id_ability =:id")
                    .addParameter("id", id)
                    .executeUpdate().getResult();
        }
        return deletedAbility == 1;
    }

    /**
     * This method deletes all the abilities on the database.
     * @return boolean
     * */
    @Override
    public boolean deleteAllAbilities() {
        try(Connection connection = sql2o.open()){
            connection
                    .createQuery("TRUNCATE \"Ability\" CASCADE")
                    .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
