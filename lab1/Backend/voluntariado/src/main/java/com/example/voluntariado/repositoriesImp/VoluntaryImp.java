package com.example.voluntariado.repositoriesImp;

import com.example.voluntariado.models.Voluntary;
import com.example.voluntariado.repositories.VoluntaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

/*
* This interface class implements the voluntary repository.
* */
@Repository
public class VoluntaryImp implements VoluntaryRepository {
    @Autowired
    private Sql2o sql2o;


    @Override
    public List<Voluntary> getAllVoluntaries() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Voluntary\"")
                    .executeAndFetch(Voluntary.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int countVoluntary() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM \"Voluntary\"").executeScalar(Integer.class);
        }
        return total;
    }


    @Override
    public List<Voluntary> getVoluntaryByRut(String rut) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Voluntary\" WHERE rut = :rut")
                    .addParameter("rut", rut)
                    .executeAndFetch(Voluntary.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntary createVoluntary(Voluntary voluntary){
        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO \"Voluntary\" (rut,fullname,birthday,state,email,password)"+
                            "values (:voluntaryRut,:voluntaryFullname,:voluntaryBirthday,:voluntaryState,:voluntaryEmail,:voluntaryPassword)")
                    .addParameter("voluntaryRut", voluntary.getRut())
                    .addParameter("voluntaryFullname", voluntary.getFullname())
                    .addParameter("voluntaryBirthday", voluntary.getBirthday())
                    .addParameter("voluntaryState", voluntary.getState())
                    .addParameter("voluntaryEmail", voluntary.getEmail())
                    .addParameter("voluntaryPassword", voluntary.getPassword())


                    .executeUpdate().getKey();
            return voluntary;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public Voluntary editVoluntary(Voluntary voluntary) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE \"Voluntary\" SET fullname = :fullname, birthday = :birthday , state = :state, email=:email, password=:password WHERE rut = :rut")
                    .addParameter("rut", voluntary.getRut())
                    .addParameter("fullname", voluntary.getFullname())
                    .addParameter("birthday", voluntary.getBirthday())
                    .addParameter("state", voluntary.getState())
                    .addParameter("email", voluntary.getEmail())
                    .addParameter("password", voluntary.getPassword())
                    .executeUpdate();
            return voluntary;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteVoluntaryById(Integer id) {
        int deletedVoluntary;
        try(Connection conn = sql2o.open()){
            deletedVoluntary = conn.createQuery("DELETE FROM \"Voluntary\" WHERE id_voluntary = :id")
                    .addParameter("id_voluntary", id)
                    .executeUpdate().getResult();
        }
        return deletedVoluntary == 1;
    }

    @Override
    public boolean deleteAllVoluntaries() {
        try(Connection conn = sql2o.open()){
            conn.createQuery("TRUNCATE \"Voluntary\" CASCADE")
                    .executeUpdate().getResult();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
