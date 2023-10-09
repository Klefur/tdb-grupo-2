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
                                "INSERT INTO task (title, description, id_user) values (:title, :desc, :uId)",
                                true
                        )
                        .addParameter("title", task.getTitle())
                        .addParameter("desc", task.getDescription())
                        .addParameter("uId", user.getId())
                        .executeUpdate().getKey();
                task.setId_user(user.getId());
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
    public List<Task> findAllByUser(Long id_user, String token) {
        if (JWT.validateToken(token)){
            try(Connection conn = sql2o.open()){
                return conn.createQuery("SELECT * FROM task WHERE id_user = :uId")
                        .addParameter("uId", id_user)
                        .executeAndFetch(Task.class);
            }catch(Exception e){
                System.out.println(e.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override
    public Boolean updateTask(Long id, Task task, String token) {
        if (JWT.validateToken(token)) {
            try(Connection conn = sql2o.open()){
                String sql = "UPDATE tasks SET";
                boolean hasUpdates = false;

                if (task.getTitle() != null) {
                    sql += " title = :title";
                    hasUpdates = true;
                }

                if (task.getDescription() != null) {
                    if (hasUpdates) {
                        sql += ",";
                    }
                    sql += " description = :description";
                    hasUpdates = true;
                }

                sql += " WHERE id = :id";

                if (!hasUpdates) {
                    // No hay actualizaciones para realizar si no se proporciona ningún valor.
                    return false;
                }
                conn.createQuery(sql)
                        .addParameter("title", task.getTitle())
                        .addParameter("description", task.getDescription())
                        .addParameter("id", task.getId())
                        .executeUpdate();

                return true;
            }catch(Exception e){
                System.out.println(e.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override
    public Boolean deleteTask(Long id, String token) {
        if (JWT.validateToken(token)) {
            try(Connection conn = sql2o.open()){
                conn.createQuery("DELETE * FROM task WHERE id = :idTask")
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
