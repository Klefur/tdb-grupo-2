package com.example.voluntariado.services;

import com.example.voluntariado.models.Emergency_Ability;
import com.example.voluntariado.repositories.Emergency_AbilityRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class Emergency_AbilityService {
    private final Emergency_AbilityRepository emergencyAbilityRepository;

    Emergency_AbilityService(Emergency_AbilityRepository emergencyAbilityRepository){
        this.emergencyAbilityRepository = emergencyAbilityRepository;
    }

    @GetMapping("/emergencies_abilities")
    public List<Emergency_Ability> getAllEmergenciesAbilities(){
        return emergencyAbilityRepository.getAllEmergenciesAbilities();
    }

    @GetMapping("/emergencies_abilities/{id_emergency_ability}")
    public List<Emergency_Ability> getEmergencyAbilityById(@PathVariable("id_emergency_ability") Integer id_emergency_ability){
        return emergencyAbilityRepository.getEmergencyAbilityById(id_emergency_ability);
    }

    @PostMapping("/emergencies_abilities")
    @ResponseBody
    public Emergency_Ability createEmergencyAbility(@RequestBody Emergency_Ability emergencyAbility){
        return emergencyAbilityRepository.createEmergencyAbility(emergencyAbility);
    }

    @PutMapping("/emergencies_abilities/{id_emergency_ability}")
    @ResponseBody
    public String editEmergencyAbility(@PathVariable("id_emergency_ability") Integer id_emergency_ability, @RequestBody Emergency_Ability emergencyAbility){
        emergencyAbility.setId_emergency_ability(id_emergency_ability);
        boolean result = emergencyAbilityRepository.editEmergencyAbility(emergencyAbility);
        if(result){
            return "Edited emergency_ability";
        }else{
            return "Emergency_ability not found";
        }
    }

    @DeleteMapping("/emergencies_abilities/{id_emergency_ability}")
    public String deleteEmergencyAbility(@PathVariable("id_emergency_ability") int id_emergency_ability){
        boolean result = emergencyAbilityRepository.deleteEmergencyAbilityById(id_emergency_ability);
        if(result){
            return "Deleted Emergency_ability";
        }
        else{
            return "Emergency_ability not found";
        }
    }

    @DeleteMapping("/emergencies_abilities")
    public String deleteAllEmergenciesAbilities(){
        boolean result = emergencyAbilityRepository.deleteAllEmergenciesAbilities();
        if(result){
            return "Deleted emergencies_abilities";
        }else{
            return "Not deleted";
        }
    }

}
