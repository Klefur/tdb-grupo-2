package com.example.demo.reposImplementados;

import com.example.demo.modelos.Ability;
import com.example.demo.repositorios.AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Sql2o;

import java.util.ArrayList;

public class AbilityImp implements AbilityRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public ArrayList<Ability> getAllAbilities() {
        try(Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM \"Ability\"").executeAndFetch(Ability.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Ability getAbilityById(Integer id) {
        return null;
    }

    @Override
    public Ability createAbility(Ability ability) {
        return null;
    }

    @Override
    public Ability editAbility(Ability ability) {
        return null;
    }

    @Override
    public boolean deleteAbilityById(Integer id) {
        return false;
    }

    @Override
    public boolean deleteAllAbilities() {
        return false;
    }
}
