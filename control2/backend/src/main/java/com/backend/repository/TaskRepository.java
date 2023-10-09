package com.backend.repository;

import com.backend.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository implements TaskRepositoryI{
    @Autowired
    private Sql2o sql2o;
    private final JwtMiddleware JWT = new JwtMiddleware();

    @Override
    public Task create(Task task, String token) {
        if (JWT.validateToken(token)){
            return new Task();
        }
        return null;
    }

    @Override
    public List<Task> findAllByUser(Long id_user, String token) {
        if (JWT.validateToken(token)){
            return new ArrayList<>();
        }
        return null;
    }

}
