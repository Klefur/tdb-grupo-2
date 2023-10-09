package com.example.voluntariado.services;

import com.example.voluntariado.models.Emergency_Ability;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.example.voluntariado.models.Voluntary_Ability;
import com.example.voluntariado.repositories.Voluntary_AbilityRepository;

import java.util.List;


@CrossOrigin
@RestController
public class Voluntary_AbilityService {
    private final Voluntary_AbilityRepository voluntary_AbilityRepository;

    Voluntary_AbilityService(Voluntary_AbilityRepository voluntary_AbilityRepository){
        this.voluntary_AbilityRepository = voluntary_AbilityRepository;
    }

    @GetMapping("/voluntary_abilities")
    public List<Voluntary_Ability> getAllVoluntariesAbilities(){
        return voluntary_AbilityRepository.getAllVoluntariesAbilities();
    }

    @GetMapping("/voluntary_abilities/{id_voluntary_ability}")
    public List<Voluntary_Ability> getVoluntaryAbilityById(@PathVariable("id_voluntary_ability") Integer id_voluntary_ability){
        return voluntary_AbilityRepository.getVoluntaryAbilityById(id_voluntary_ability);
    }

    @PostMapping("/voluntary_abilities")
    @ResponseBody
    public Voluntary_Ability createEmergencyAbility(@RequestBody Voluntary_Ability voluntary_ability){
        return voluntary_AbilityRepository.createVoluntaryAbility(voluntary_ability);
    }

    @PutMapping("/voluntary_abilities/{id_voluntary_ability}")
    @ResponseBody
    public String editVoluntaryAbility(@PathVariable("id_voluntary_ability") Integer id_voluntary_ability, @RequestBody Voluntary_Ability voluntary_ability){
        voluntary_ability.setId_voluntary_ability(id_voluntary_ability);
        boolean result = voluntary_AbilityRepository.editVoluntaryAbility(voluntary_ability);
        if(result){
            return "Edited voluntary_ability";
        }else{
            return "voluntary_ability not found";
        }
    }

    @DeleteMapping("/voluntary-abilities/{id_voluntary_ability}")
    public String deleteVoluntaryAbility(@PathVariable("id_voluntary_ability") int id_voluntary_ability){
        boolean result = voluntary_AbilityRepository.deleteVoluntaryAbilityById(id_voluntary_ability);
        if(result){
            return "Edited Voluntary_Ability";
        }
        else{
            return "Voluntary_Ability not found";
        }
    }


}
