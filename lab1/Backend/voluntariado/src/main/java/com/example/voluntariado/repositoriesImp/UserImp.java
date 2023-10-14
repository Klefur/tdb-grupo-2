package com.example.voluntariado.repositoriesImp;

import com.example.voluntariado.models.User;
import com.example.voluntariado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class UserImp implements UserRepository {
    @Autowired
    private Sql2o sql2o;

    @Autowired
    private JwtMiddlewareImp JWT;

    @Override
    public List<User> getAllUsers(){
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM \"User\"")
                    .executeAndFetch(User.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public String createUser(User user){
        try(Connection connection = sql2o.open()){
            Integer insertedId = (Integer) connection
                    .createQuery("INSERT INTO \"User\" (username, password) values (:username, :password)", true)
                    .addParameter("username", user.getUsername())
                    .addParameter("password", user.getPassword())
                    .executeUpdate().getKey();
            user.setId(insertedId.longValue());
            return JWT.generateToken(user);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public User findByUsername(String username){
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM \"User\" WHERE username =:username")
                    .addParameter("username", username)
                    .executeAndFetch(User.class).get(0);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String login(String username, String password){
        try{
            User user = findByUsername(username);
            if(user.getPassword().compareTo(password) == 0){
                return JWT.generateToken(user);
            }
            return "Contraseña incorrecta";
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
