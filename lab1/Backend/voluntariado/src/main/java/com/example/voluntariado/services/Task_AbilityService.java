package com.example.voluntariado.services;

import com.example.voluntariado.models.Task_Ability;
import com.example.voluntariado.repositories.Task_AbilityRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class Task_AbilityService {
    private final Task_AbilityRepository taskAbilityRepository;

    public Task_AbilityService(Task_AbilityRepository taskAbilityRepository){
        this.taskAbilityRepository = taskAbilityRepository;
    }

    @GetMapping("/tasks_abilities")
    public List<Task_Ability> getAllTasksAbilities(){
        return taskAbilityRepository.getAllTasksAbilities();
    }

    @GetMapping("/tasks_abilities/{id_task_ability}")
    public List<Task_Ability> getTaskAbilityById(@PathVariable("id_task_ability") Integer id_task_ability){
        return taskAbilityRepository.getTaskAbilityById(id_task_ability);
    }

    @PostMapping("/tasks_abilities")
    @ResponseBody
    public Task_Ability createTaskAbility(@RequestBody Task_Ability taskAbility){
        return taskAbilityRepository.createTaskAbility(taskAbility);
    }

    @PutMapping("/tasks_abilities/{id_task_ability}")
    @ResponseBody
    public String editTaskAbility(@PathVariable("id_task_ability") Integer id_task_ability, @RequestBody Task_Ability taskAbility){
        taskAbility.setId_task_ability(id_task_ability);
        boolean result = taskAbilityRepository.editTaskAbility(taskAbility);
        if(result){
            return "Edited Task Ability";
        }else{
            return "Task Ability not found ";
        }
    }

    @DeleteMapping("/tasks_abilities/{id_task_ability}")
    @ResponseBody
    public String deleteTaskAbilityById(@PathVariable("id_task_ability") Integer id_task_ability){
        boolean result = taskAbilityRepository.deleteTaskAbilityById(id_task_ability);
        if(result){
            return "Deleted Task Ability";
        }else{
            return "Task Ability not found";
        }
    }

    @DeleteMapping("/tasks_abilities")
    public String deleteAllTasksAbilities(){
        boolean result = taskAbilityRepository.deleteAllTasksAbilities();
        if(result){
            return "Deleted Tasks_Abilities";
        }else{
            return "Not deleted";
        }
    }
}
