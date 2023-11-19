package com.example.voluntariado.services;

import com.example.voluntariado.models.Task;
import com.example.voluntariado.repositories.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks(){
        return taskRepository.getAllTasks();
    }

    @GetMapping("/countTasks/{id_emergency}")
    public Integer countActiveTasksByEmergencyId(@PathVariable("id_emergency") Integer id_emergency){
        return taskRepository.countActiveTasksByEmergencyId(id_emergency);
    }

    @GetMapping("/allActiveTasks")
    public Integer countAllActiveTasks(@RequestParam String token){
        return taskRepository.countAllActiveTasks(token);
    }

    @GetMapping("/tasks/{id_task}")
    public List<Task> getTaskById(@PathVariable("id_task") Integer id_task){
        return taskRepository.getTaskById(id_task);
    }

    @PostMapping("/tasks")
    @ResponseBody
    public Task createTask(@RequestBody Task task){
        return taskRepository.createTask(task);
    }

    @PutMapping("/tasks/{id_task}")
    @ResponseBody
    public String editTask(@PathVariable("id_task") Integer id_task, @RequestBody Task task){
        task.setId_task(id_task);
        boolean result = taskRepository.editTask(task);
        if(result){
            return "Edited Task";
        }else{
            return "Task not found";
        }
    }

    @DeleteMapping("/tasks/{id_task}")
    @ResponseBody
    public String deleteTaskById(@PathVariable("id_task") Integer id_task){
        boolean result = taskRepository.deleteTaskById(id_task);
        if(result){
            return "Deleted Task";
        }else{
            return "Task not found";
        }
    }

    @DeleteMapping("/tasks")
    public String deleteAllTasks(){
        boolean result = taskRepository.deleteAllTasks();
        if(result){
            return "Deleted tasks";
        }else{
            return "Not deleted";
        }
    }
}
