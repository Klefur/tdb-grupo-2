package com.example.voluntariado.repositoriesImp;

import com.example.voluntariado.models.Institution;
import com.example.voluntariado.repositories.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

/*
* This interface class implements the institution repository.
* */
@Repository
public class InstitutionImp implements InstitutionRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Institution> getAllInstitutions() {
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM \"Institution\"")
                    .executeAndFetch(Institution.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Institution> getInstitutionById(Integer id) {
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM \"Institution\" WHERE id_institution =:id")
                    .addParameter("id_institution", id)
                    .executeAndFetch(Institution.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Institution createInstitution(Institution institution) {
        try(Connection connection = sql2o.open()){
            connection
                    .createQuery("INSERT INTO \"Institution\" (name, coordinator_name, email, password)"
                    + "VALUES (:name, :coordinator_name, :email, :password)")
                    .addParameter("name", institution.getName())
                    .addParameter("coordinator_name", institution.getCoordinator_name())
                    .addParameter("email", institution.getEmail())
                    .addParameter("password", institution.getPassword())
                    .executeUpdate().getKey();
            return institution;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Institution editInstitution(Institution institution) {
        try(Connection connection = sql2o.open()){
            connection.
                    createQuery("UPDATE \"Institution\" SET name =:name, coordinator_name =:coordinator_name, email =:email, password =:password WHERE id_institution =:id_institution")
                    .addParameter("name", institution.getName())
                    .addParameter("coordinator_name", institution.getCoordinator_name())
                    .addParameter("email", institution.getEmail())
                    .addParameter("password", institution.getPassword());
            return institution;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteInstitutionById(Integer id) {
        int deletedInstitution;
        try(Connection connection = sql2o.open()){
            deletedInstitution = connection
                    .createQuery("DELETE FROM \"Institution\" WHERE id_institution =:id")
                    .addParameter("id_institution", id)
                    .executeUpdate().getResult();
        }
        return deletedInstitution == 1;
    }

    @Override
    public boolean deleteAllInstitutions() {
        try(Connection connection = sql2o.open()){
            connection
                    .createQuery("TRUNCATE \"Institution\" CASCADE")
                    .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
