package com.example.voluntariado.repositoriesImp;

import com.example.demo.modelos.Task;
import com.example.demo.repositorios.TaskRepository;

import java.util.ArrayList;

public class TaskImp implements TaskRepository {
    @Override
    public ArrayList<Task> getAllTasks() {
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
