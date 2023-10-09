package com.backend.repository;

import com.backend.model.Task;

import java.util.List;

public interface TaskRepositoryI {
    public Task create(Task task, String token);
    public List<Task> findAllByUser(String token);
    public String updateTask(Long id, Task task, String token);
    public Boolean deleteTask(Long id, String token);
}
