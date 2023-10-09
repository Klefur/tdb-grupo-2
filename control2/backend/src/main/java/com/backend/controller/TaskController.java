package com.backend.controller;

import com.backend.model.Task;
import com.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TaskController {
    @Autowired
    private TaskRepository taskRep;

    @PostMapping("/new-task")
    public Task uploadTask(@RequestBody Task task, @RequestParam String token) {
        return taskRep.create(task, token);
    }

    @GetMapping("/home")
    public List<Task> allTask(@RequestParam String token) {
        return taskRep.findAllByUser(token);
    }

    @PutMapping("/update-task/{id}")
    public String updateTask(@PathVariable Long id,@RequestBody Task task, @RequestParam String token) {
        return taskRep.updateTask(id, task, token);
    }

    @DeleteMapping("/delete-task/{id}")
    public Boolean deleteTask(@PathVariable Long id, @RequestParam String token) {
        return taskRep.deleteTask(id, token);
    }
}
