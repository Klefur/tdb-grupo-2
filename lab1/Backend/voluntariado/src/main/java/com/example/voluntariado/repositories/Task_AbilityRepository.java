package com.example.voluntariado.repositories;

import com.example.voluntariado.models.Task_Ability;

import java.util.List;

public interface Task_AbilityRepository {
    public List<Task_Ability> getAllTasksAbilities();
    public Task_Ability getTaskAbilityById(Integer id);
    public Task_Ability createTaskAbility(Task_Ability taskAbility);
    public Task_Ability editTaskAbility(Task_Ability taskAbility);
    public boolean deleteTaskAbilityById(Integer id);
    public boolean deleteAllTasksAbilities();
}
