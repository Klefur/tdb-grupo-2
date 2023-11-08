package com.example.voluntariado.repositories;

import com.example.voluntariado.models.Ranking;
import com.example.voluntariado.models.Task_Ability;

import java.util.List;

/*
 * This interface class represents the task with an ability repository.
 * */
public interface Task_AbilityRepository {
    public List<Task_Ability> getAllTasksAbilities();
    public List<Task_Ability> getTaskAbilityById(Integer id);
    public Task_Ability createTaskAbility(Task_Ability taskAbility);
    public boolean editTaskAbility(Task_Ability taskAbility);
    public boolean deleteTaskAbilityById(Integer id);
    public boolean deleteAllTasksAbilities();
}
