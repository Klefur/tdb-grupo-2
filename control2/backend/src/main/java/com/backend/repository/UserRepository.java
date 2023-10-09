package com.backend.repository;

import com.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class UserRepository implements UserRepositoryI{
    @Autowired
    private Sql2o sql2o;
    @Autowired
    private JwtMiddleware JWT;

    @Override
    public String create(User user) {
        try(Connection conn = sql2o.open()){
            Integer insertedId = (Integer) conn.createQuery(
                            "INSERT INTO \"user\" (username, password) values (:name, :pass)",
                            true
                    )
                    .addParameter("name", user.getUsername())
                    .addParameter("pass", user.getPassword())
                    .executeUpdate().getKey();
            user.setId(insertedId.longValue());
            return JWT.generateToken(user);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<User> findAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"user\"")
                    .executeAndFetch(User.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public User findByUsername(String username) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"user\" WHERE username=:name")
                    .addParameter("name", username)
                    .executeAndFetch(User.class).get(0);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String login(String username, String password) {
        try {
            User user = findByUsername(username);
            if (user.getPassword().compareTo(password) == 0) {
                return JWT.generateToken(user);
            }
            return "Clave erronea";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
