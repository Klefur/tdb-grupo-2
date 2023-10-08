package com.example.voluntariado.repositories;

import com.example.voluntariado.models.Voluntary_Ability;

import java.util.List;

public interface Voluntary_AbilityRepository {
    public List<Voluntary_Ability> getAllVoluntariesAbilities();
    public List<Voluntary_Ability> getVoluntaryById(Integer id);
    public Voluntary_Ability createVoluntary(Voluntary_Ability voluntaryAbility);
    public Voluntary_Ability editVoluntaryAbility(Voluntary_Ability voluntaryAbility);
    public boolean deleteVoluntaryAbilityById(Integer id);
    public boolean deleteAllVoluntariesAbilities();
}
