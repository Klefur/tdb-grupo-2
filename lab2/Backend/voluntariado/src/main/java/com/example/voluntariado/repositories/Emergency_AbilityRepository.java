package com.example.voluntariado.repositories;

import com.example.voluntariado.models.Emergency_Ability;

import java.util.ArrayList;
import java.util.List;

/*
 * This interface class represents the emergency with an ability repository.
 * */
public interface Emergency_AbilityRepository {
    public List<Emergency_Ability> getAllEmergenciesAbilities();
    public List<Emergency_Ability> getEmergencyAbilityById(Integer id);
    public Emergency_Ability createEmergencyAbility(Emergency_Ability emergencyAbility);
    public boolean editEmergencyAbility(Emergency_Ability emergencyAbility);
    public boolean deleteEmergencyAbilityById(Integer id);
    public boolean deleteAllEmergenciesAbilities();
}
