package com.example.voluntariado.repositoriesImp;


import com.example.voluntariado.models.Voluntary_Ability;
import com.example.voluntariado.repositories.Voluntary_AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

/*
* This interface class implements the voluntary_ability repository.
* */
@Repository
public class Voluntary_AbilityImp implements Voluntary_AbilityRepository {

    @Autowired
    private Sql2o sql2o;
    @Override
    public List<Voluntary_Ability> getAllVoluntariesAbilities() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Vol_ability\"").
                    executeAndFetch(Voluntary_Ability.class);
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Voluntary_Ability> getVoluntaryAbilityById(Integer id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Voluntary_Ability\" WHERE id_voluntary_ability = :id")
                    .addParameter("id_voluntary_ability", id)
                    .executeAndFetch(Voluntary_Ability.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntary_Ability createVoluntaryAbility(Voluntary_Ability voluntaryAbility) {
        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO \"Voluntary_Ability\" (id_voluntary, id_ability) VALUES (:id_voluntary, :id_ability)", true)
                    .addParameter("id_voluntary", voluntaryAbility.getId_voluntary())
                    .addParameter("id_ability", voluntaryAbility.getId_ability())
                    .executeUpdate()
                    .getKey();
            voluntaryAbility.setId_voluntary_ability(insertedId);
            return voluntaryAbility;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public boolean editVoluntaryAbility(Voluntary_Ability voluntaryAbility) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE \"Voluntary_Ability\" SET id_voluntary = :id_voluntary, id_ability = :id_ability WHERE id_voluntary_ability = :id")
                    .addParameter("id_voluntary", voluntaryAbility.getId_voluntary())
                    .addParameter("id_ability", voluntaryAbility.getId_ability())
                    .addParameter("id", voluntaryAbility.getId_voluntary_ability())
                    .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteVoluntaryAbilityById(Integer id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM \"Voluntary_Ability\" WHERE id_voluntary_ability = :id")
                    .addParameter("id_voluntary_ability", id)
                    .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteAllVoluntariesAbilities() {
        try(Connection conn = sql2o.open()){
            conn.createQuery("TRUNCATE \"Voluntary_Ability\" CASCADE")
                    .executeUpdate().getResult();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
