package com.backend.controller;

import com.backend.model.Task;
import com.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
    @Autowired
    private TaskRepository taskRep;

    @PostMapping("/new-task")
    public Task uploadTask(@RequestBody Task task, @RequestParam String token) {
        return taskRep.create(task, token);
    }
}
