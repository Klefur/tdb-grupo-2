package com.example.voluntariado.repositories;

import com.example.voluntariado.models.Voluntary_Ability;

import java.util.List;

/*
 * This interface class represents the voluntary with an ability repository.
 * */
public interface Voluntary_AbilityRepository {
    public List<Voluntary_Ability> getAllVoluntariesAbilities();
    public List<Voluntary_Ability> getVoluntaryAbilityById(Integer id);
    public Voluntary_Ability createVoluntaryAbility(Voluntary_Ability voluntaryAbility);
    public boolean editVoluntaryAbility(Voluntary_Ability voluntaryAbility);
    public boolean deleteVoluntaryAbilityById(Integer id);
    public boolean deleteAllVoluntariesAbilities();
}
