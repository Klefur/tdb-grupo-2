package com.backend.repository;

import com.backend.model.Task;
import com.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository implements TaskRepositoryI{
    @Autowired
    private Sql2o sql2o;
    @Autowired
    private JwtMiddleware JWT;

    @Override
    public Task create(Task task, String token) {
        if (JWT.validateToken(token)){
            try(Connection conn = sql2o.open()){
                User user = JWT.decodeJWT(token);
                Integer insertedId = (Integer) conn.createQuery(
                                "INSERT INTO task (title, description, expire_date, id_user) " +
                                        "values (:title, :desc,  :exp_date, :uId)",
                                true
                        )
                        .addParameter("title", task.getTitle())
                        .addParameter("desc", task.getDescription())
                        .addParameter("uId", user.getId())
                        .addParameter("exp_date", task.getExpire_date())
                        .executeUpdate().getKey();
                task.setId_user(user.getId());
                task.setCompleted(false);
                task.setId(insertedId.longValue());
                return task;
            }catch(Exception e){
                System.out.println(e.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override
    public List<Task> findAllByUser(String token) {
        if (JWT.validateToken(token)){
            Long uId = JWT.decodeJWT(token).getId();
            try(Connection conn = sql2o.open()){
                return conn.createQuery("SELECT * FROM task WHERE id_user = :uId")
                        .addParameter("uId", uId)
                        .executeAndFetch(Task.class);
            }catch(Exception e){
                System.out.println(e.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override
    public String updateTask(Long id, Task task, String token) {
        if (!JWT.validateToken(token)) {
            return "Id erroneo";
        }

        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE task SET ";
            List<String> updates = new ArrayList<>();

            if (task.getTitle() != null) {
                updates.add("title = :title");
            }

            if (task.getDescription() != null) {
                updates.add("description = :description");
            }

            if (task.getExpire_date() != null) {
                updates.add("expire_date = :exp_date");
            }

            if (task.getCompleted() != null) {
                updates.add("completed = :completed");
            }

            if (updates.isEmpty()) {
                return "No se actualizó";
            }

            sql += String.join(", ", updates);
            sql += " WHERE id = :id";

            org.sql2o.Query query = conn.createQuery(sql)
                    .addParameter("id", id);

            if (task.getTitle() != null) {
                query.addParameter("title", task.getTitle());
            }

            if (task.getDescription() != null) {
                query.addParameter("description", task.getDescription());
            }

            if (task.getExpire_date() != null) {
                query.addParameter("exp_date", task.getExpire_date());
            }

            if (task.getCompleted() != null) {
                query.addParameter("completed", task.getCompleted());
            }

            System.out.println(sql);
            query.executeUpdate();

            return "Actualizado";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error";
        }
    }

    @Override
    public Boolean deleteTask(Long id, String token) {
        if (JWT.validateToken(token)) {
            try(Connection conn = sql2o.open()){
                conn.createQuery("DELETE FROM task WHERE id = :idTask")
                        .addParameter("idTask", id)
                        .executeUpdate();
                return true;
            }catch(Exception e){
                System.out.println(e.getMessage());
                return false;
            }
        }
        return null;
    }

}
