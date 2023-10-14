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
            return conn.createQuery("SELECT * FROM \"task\"")
                    .executeAndFetch(Task.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Integer countActiveTasksByEmergencyId(Integer id){
        int activeTasks = 0;
        try(Connection connection = sql2o.open()){
            activeTasks = connection
                    .createQuery("SELECT COUNT(*) FROM \"task\" WHERE id_emergency = :id AND state = '1'")
                    .addParameter("id", id)
                    .executeScalar(Integer.class);
        }
        return activeTasks;
    }

    @Override
    public List<Task> getTaskById(Integer id) {
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM \"task\" WHERE id_task = :id")
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
            conn.createQuery("INSERT INTO \"task\" (name, description, state, id_institution)"+
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
    public boolean editTask(Task task) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE \"task\" SET name = :name, description = :description, state = :state, id_emergency = :id_emergency WHERE id_task = :id_task")
                    .addParameter("id_task", task.getId_task())
                    .addParameter("name", task.getName())
                    .addParameter("description", task.getDescription())
                    .addParameter("state", task.getState())
                    .addParameter("id_emergency", task.getId_emergency())
                    .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteTaskById(Integer id) {
        int deletedTask;
        try(Connection conn = sql2o.open()){
            deletedTask = conn.createQuery("DELETE FROM \"task\" WHERE id_task = :id")
                    .addParameter("id_task", id)
                    .executeUpdate().getResult();
        }
        return deletedTask == 1;
    }

    @Override
    public boolean deleteAllTasks() {
        try(Connection conn = sql2o.open()){
            conn.createQuery("TRUNCATE \"task\" CASCADE")
                    .executeUpdate().getResult();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}

