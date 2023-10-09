package com.example.voluntariado.repositories;

import com.example.voluntariado.models.Task;

import java.util.List;

/*
 * This interface class represents the task repository.
 * */
public interface TaskRepository {
    public List<Task> getAllTasks();
    public int countTasksByEmergencyId(Integer id);
    public List<Task> getTaskById(Integer id);
    public Task createTask(Task task);
    public boolean editTask(Task task);
    public boolean deleteTaskById(Integer id);
    public boolean deleteAllTasks();
}
