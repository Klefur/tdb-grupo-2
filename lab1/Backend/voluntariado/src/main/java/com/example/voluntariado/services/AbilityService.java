package com.example.voluntariado.services;

import com.example.voluntariado.models.Ability;
import com.example.voluntariado.repositories.AbilityRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AbilityService {
    private final AbilityRepository abilityRepository;

    AbilityService(AbilityRepository abilityRepository){
        this.abilityRepository = abilityRepository;
    }

    @GetMapping("/abilities")
    public List<Ability> getAllAbilities(){
        return abilityRepository.getAllAbilities();
    }

    @GetMapping("/abilities/{id_ability}")
    public List<Ability> getAbilityById(@PathVariable("id_ability") Integer id_ability){
        return abilityRepository.getAbilityById(id_ability);
    }

    @PostMapping("/abilities")
    @ResponseBody
    public Ability createAbility(@RequestBody Ability ability){
        return abilityRepository.createAbility(ability);
    }

    @PutMapping("/abilities/{id_ability}")
    @ResponseBody
    public String editAbility(@PathVariable("id_ability") Integer id_ability, @RequestBody Ability ability){
        ability.setId_ability(id_ability);
        boolean result = abilityRepository.editAbility(ability);
        if(result){
            return "Edited ability";
        }else{
            return "Ability not found";
        }
    }
}
