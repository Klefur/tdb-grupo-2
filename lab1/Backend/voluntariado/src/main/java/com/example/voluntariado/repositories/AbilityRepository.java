package com.example.voluntariado.repositories;


import com.example.voluntariado.models.Ability;

import java.util.List;

/*
* This interface class represents the ability repository.
* */
public interface AbilityRepository {

    public List<Ability> getAllAbilities();
    public List<Ability> getAbilityById(Integer id);
    public Ability createAbility(Ability ability);
    public boolean editAbility(Ability ability);
    public boolean deleteAbilityById(Integer id);
    public boolean deleteAllAbilities();
}
