package com.example.voluntariado.repositoriesImp;

import com.example.voluntariado.models.Emergency_Ability;
import com.example.voluntariado.repositories.Emergency_AbilityRepository;

import java.util.List;

public class Emergency_AbilityImp implements Emergency_AbilityRepository {
    @Override
    public List<Emergency_Ability> getAllEmergenciesAbilities() {
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
