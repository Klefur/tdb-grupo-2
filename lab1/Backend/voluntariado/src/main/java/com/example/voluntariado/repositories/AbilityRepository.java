package com.example.voluntariado.repositories;


import com.example.voluntariado.models.Ability;

import java.util.List;

public interface AbilityRepository {
    public List<Ability> getAllAbilities();
    public Ability getAbilityById(Integer id);
    public Ability createAbility(Ability ability);
    public Ability editAbility(Ability ability);
    public boolean deleteAbilityById(Integer id);
    public boolean deleteAllAbilities();
}
