package com.example.voluntariado.repositories;

import com.example.demo.modelos.Task_Ability;

import java.util.ArrayList;

public interface Task_AbilityRepository {
    public ArrayList<Task_Ability> getAllTasksAbilities();
    public Task_Ability getTaskAbilityById(Integer id);
    public Task_Ability createTaskAbility(Task_Ability taskAbility);
    public Task_Ability editTaskAbility(Task_Ability taskAbility);
    public boolean deleteTaskAbilityById(Integer id);
    public boolean deleteAllTasksAbilities();
}
