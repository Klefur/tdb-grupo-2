package com.example.demo.reposImplementados;

import com.example.demo.modelos.Emergency_Ability;
import com.example.demo.repositorios.Emergency_AbilityRepository;

import java.util.ArrayList;

public class Emergency_AbilityImp implements Emergency_AbilityRepository {
    @Override
    public ArrayList<Emergency_Ability> getAllEmergenciesAbilities() {
        return null;
    }

    @Override
    public Emergency_Ability getEmergencyAbilityById(Integer id) {
        return null;
    }

    @Override
    public Emergency_Ability createEmergencyAbility(Emergency_Ability emergencyAbility) {
        return null;
    }

    @Override
    public Emergency_Ability editEmergencyAbility(Emergency_Ability emergencyAbility) {
        return null;
    }

    @Override
    public boolean deleteEmergencyAbilityById(Emergency_Ability emergencyAbility) {
        return false;
    }

    @Override
    public boolean deleteAllEmergenciesAbilities() {
        return false;
    }
}
