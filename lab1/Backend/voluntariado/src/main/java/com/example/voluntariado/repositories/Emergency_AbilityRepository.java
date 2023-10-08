package com.example.voluntariado.repositories;

import com.example.demo.modelos.Emergency_Ability;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface Emergency_AbilityRepository {
    public ArrayList<Emergency_Ability> getAllEmergenciesAbilities();
    public Emergency_Ability getEmergencyAbilityById(Integer id);
    public Emergency_Ability createEmergencyAbility(Emergency_Ability emergencyAbility);
    public Emergency_Ability editEmergencyAbility(Emergency_Ability emergencyAbility);
    public boolean deleteEmergencyAbilityById(Emergency_Ability emergencyAbility);
    public boolean deleteAllEmergenciesAbilities();
}
