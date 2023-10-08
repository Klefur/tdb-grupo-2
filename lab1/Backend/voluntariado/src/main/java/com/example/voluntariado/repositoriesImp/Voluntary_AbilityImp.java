package com.example.demo.reposImplementados;

import com.example.demo.modelos.Voluntary_Ability;
import com.example.demo.repositorios.Voluntary_AbilityRepository;

import java.util.ArrayList;

public class Voluntary_AbilityImp implements Voluntary_AbilityRepository {
    @Override
    public ArrayList<Voluntary_Ability> getAllVoluntariesAbilities() {
        return null;
    }

    @Override
    public Voluntary_Ability getVoluntaryById(Integer id) {
        return null;
    }

    @Override
    public Voluntary_Ability createVoluntary(Voluntary_Ability voluntaryAbility) {
        return null;
    }

    @Override
    public Voluntary_Ability editVoluntary(Voluntary_Ability voluntaryAbility) {
        return null;
    }

    @Override
    public boolean deleteVoluntaryAbilityById(Integer id) {
        return false;
    }

    @Override
    public boolean deleteAllVoluntariesAbilities() {
        return false;
    }
}
