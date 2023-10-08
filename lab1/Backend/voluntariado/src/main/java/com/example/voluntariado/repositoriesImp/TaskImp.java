package com.example.voluntariado.repositoriesImp;

import com.example.voluntariado.models.Task;
import com.example.voluntariado.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import java.util.List;

/*
* This interface class implements the task repository.
* */
@Repository
public class TaskImp implements TaskRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Task> getAllTasks() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Task\"")
                    .executeAndFetch(Task.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int countTasksByEmergencyId(Integer id) {
        // Implementa tu lógica aquí
        return 0;
    }

    @Override
    public List<Task> getTaskById(Integer id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Task\" WHERE id_task = :id")
                    .addParameter("id_task", id)
                    .executeAndFetch(Task.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Task createTask(Task task) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO \"Task\" (name, description, state, id_institution)"+
                            "values (:taskName, :taskDescription, :taskState, :taskInstitution)")
                    .addParameter("taskName", task.getName())
                    .addParameter("taskDescription", task.getDescription())
                    .addParameter("taskState", task.getState())
                    .addParameter("taskInstitution", task.getId_institution())
                    .executeUpdate().getKey();
            return task;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Task editTask(Task task) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE \"Task\" SET name = :name, description = :description, state = :state, id_institution = :id_institution WHERE id_task = :id_task")
                    .addParameter("id_task", task.getId_task())
                    .addParameter("name", task.getName())
                    .addParameter("description", task.getDescription())
                    .addParameter("state", task.getState())
                    .addParameter("id_institution", task.getId_institution())
                    .executeUpdate();
            return task;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteTaskById(Integer id) {
        int deletedTask;
        try(Connection conn = sql2o.open()){
            deletedTask = conn.createQuery("DELETE FROM \"Task\" WHERE id_task = :id")
                    .addParameter("id_task", id)
                    .executeUpdate().getResult();
        }
        return deletedTask == 1;
    }

    @Override
    public boolean deleteAllTasks() {
        try(Connection conn = sql2o.open()){
            conn.createQuery("TRUNCATE \"Task\" CASCADE")
                    .executeUpdate().getResult();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}

