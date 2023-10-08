package com.example.voluntariado.repositories;

import com.example.demo.modelos.Voluntary_Ability;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface Voluntary_AbilityRepository {
    public ArrayList<Voluntary_Ability> getAllVoluntariesAbilities();
    public Voluntary_Ability getVoluntaryById(Integer id);
    public Voluntary_Ability createVoluntary(Voluntary_Ability voluntaryAbility);
    public Voluntary_Ability editVoluntary(Voluntary_Ability voluntaryAbility);
    public boolean deleteVoluntaryAbilityById(Integer id);
    public boolean deleteAllVoluntariesAbilities();
}
