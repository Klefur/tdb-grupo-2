package com.backend.repository;

import com.backend.model.Task;

import java.util.List;

public interface TaskRepositoryI {
    public Task create(Task task, String token);
    public List<Task> findAllByUser(Long id_user, String token);
}
