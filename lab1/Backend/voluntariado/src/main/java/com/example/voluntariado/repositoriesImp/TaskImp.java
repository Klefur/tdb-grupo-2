package com.example.voluntariado.repositoriesImp;

import com.example.voluntariado.models.Task;
import com.example.voluntariado.repositories.TaskRepository;

import java.util.List;

public class TaskImp implements TaskRepository {
    @Override
    public List<Task> getAllTasks() {
        return null;
    }

    @Override
    public int countTasksByEmergencyId(Integer id) {
        return 0;
    }

    @Override
    public Task getTaskById(Integer id) {
        return null;
    }

    @Override
    public Task createTask(Task task) {
        return null;
    }

    @Override
    public Task editTask(Task task) {
        return null;
    }

    @Override
    public boolean deleteTaskById(Integer id) {
        return false;
    }

    @Override
    public boolean deleteAllTasks() {
        return false;
    }
}
