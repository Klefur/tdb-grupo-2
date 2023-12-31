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

    /**
     * This method gets all the institutions on the database.
     * @return List<Institution>
     * */
    @Override
    public List<Institution> getAllInstitutions() {
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM \"institution\"")
                    .executeAndFetch(Institution.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * This method gets an institution given an id.
     * @param id
     * @return List<Institution>
     * */
    @Override
    public List<Institution> getInstitutionById(Integer id) {
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM \"institution\" WHERE id_institution =:id")
                    .addParameter("id_institution", id)
                    .executeAndFetch(Institution.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * This method creates an institution and puts it on the database.
     * @param institution
     * @return Institution
     * */
    @Override
    public Institution createInstitution(Institution institution) {
        try(Connection connection = sql2o.open()){
            connection
                    .createQuery("INSERT INTO \"institution\" (name, coordinator_name, email, password)"
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

    /**
     * This method edits the institution and updates it on the database.
     * @param institution
     * @return Institution
     * */
    @Override
    public boolean editInstitution(Institution institution) {
        try(Connection connection = sql2o.open()){
            connection.
                    createQuery("UPDATE \"institution\" SET name =:name, coordinator_name =:coordinator_name, email =:email, password =:password WHERE id_institution =:id_institution")
                    .addParameter("name", institution.getName())
                    .addParameter("coordinator_name", institution.getCoordinator_name())
                    .addParameter("email", institution.getEmail())
                    .addParameter("password", institution.getPassword());
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * This method deletes an institution on the database given an id.
     * @param id
     * @return boolean
     * */
    @Override
    public boolean deleteInstitutionById(Integer id) {
        int deletedInstitution;
        try(Connection connection = sql2o.open()){
            deletedInstitution = connection
                    .createQuery("DELETE FROM \"institution\" WHERE id_institution =:id")
                    .addParameter("id_institution", id)
                    .executeUpdate().getResult();
        }
        return deletedInstitution == 1;
    }

    /**
     * This method deletes all the institutions on the database.
     * @return boolean
     * */
    @Override
    public boolean deleteAllInstitutions() {
        try(Connection connection = sql2o.open()){
            connection
                    .createQuery("TRUNCATE \"institution\" CASCADE")
                    .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
