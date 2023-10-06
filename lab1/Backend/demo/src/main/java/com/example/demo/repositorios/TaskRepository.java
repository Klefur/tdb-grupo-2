package com.example.demo.repositorios;

import com.example.demo.modelos.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface TaskRepository {
    public ArrayList<Task> getAllTasks();
    public int countTasksByEmergencyId(Integer id);
    public Task getTaskById(Integer id);
    public Task createTask(Task task);
    public Task editTask(Task task);
    public boolean deleteTaskById(Integer id);
    public boolean deleteAllTasks();
}
