package com.example.voluntariado.repositories;

import com.example.demo.modelos.Ability;

import java.util.ArrayList;

public interface AbilityRepository {
    public ArrayList<Ability> getAllAbilities();
    public Ability getAbilityById(Integer id);
    public Ability createAbility(Ability ability);
    public Ability editAbility(Ability ability);
    public boolean deleteAbilityById(Integer id);
    public boolean deleteAllAbilities();
}
