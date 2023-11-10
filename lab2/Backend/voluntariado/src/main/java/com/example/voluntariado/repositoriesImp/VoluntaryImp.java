package com.example.voluntariado.repositoriesImp;

import com.example.voluntariado.models.Emergency;
import com.example.voluntariado.models.Voluntary;
import com.example.voluntariado.repositories.VoluntaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.awt.*;
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
            return conn.createQuery("SELECT * FROM \"voluntary\"")
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
            total = conn.createQuery("SELECT COUNT(*) FROM \"voluntary\"").executeScalar(Integer.class);
        }
        return total;
    }


    @Override
    public List<Voluntary> getVoluntaryByRut(String rut) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"voluntary\" WHERE rut = :rut")
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
            conn.createQuery("INSERT INTO \"voluntary\" (rut,fullname,birthday,state,email,password)"+
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
    public boolean editVoluntary(Voluntary voluntary) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE \"voluntary\" SET fullname = :fullname, birthday = :birthday , state = :state, email=:email, password=:password WHERE rut = :rut")
                    .addParameter("rut", voluntary.getRut())
                    .addParameter("fullname", voluntary.getFullname())
                    .addParameter("birthday", voluntary.getBirthday())
                    .addParameter("state", voluntary.getState())
                    .addParameter("email", voluntary.getEmail())
                    .addParameter("password", voluntary.getPassword())
                    .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteVoluntaryById(Integer id) {
        int deletedVoluntary;
        try(Connection conn = sql2o.open()){
            deletedVoluntary = conn.createQuery("DELETE FROM \"voluntary\" WHERE id_voluntary = :id")
                    .addParameter("id_voluntary", id)
                    .executeUpdate().getResult();
        }
        return deletedVoluntary == 1;
    }

    @Override
    public boolean deleteAllVoluntaries() {
        try(Connection conn = sql2o.open()){
            conn.createQuery("TRUNCATE \"voluntary\" CASCADE")
                    .executeUpdate().getResult();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Voluntary> findVoluntariesByLocationNear(Integer id_emergency, Double distance){
        String sql = "SELECT *, (6371 * acos(cos(radians:emergency.latitude)) * cos(radians(emergency.latitude)) * cos(radians(emergency.longitude) - radians(emergency.longitude)) + sin(radians(emergency.latitude)) * sin(radians(emergency.latitude)))) AS distance "+
                "FROM voluntary, emergency" +
                "WHERE voluntary.state = 1 AND emergency.id_emergency =:id_emergency " +
                "HAVING distance < :distance "+
                "ORDER BY distance";
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery(sql)
                    .executeAndFetch(Voluntary.class);
        }
    }
}
