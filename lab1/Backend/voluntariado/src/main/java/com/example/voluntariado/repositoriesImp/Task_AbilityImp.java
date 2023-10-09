package com.example.voluntariado.repositoriesImp;

import com.example.voluntariado.models.Task_Ability;
import com.example.voluntariado.repositories.Task_AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

/*
* This interface class implements the task_ability repository.
* */
@Repository
public class Task_AbilityImp implements Task_AbilityRepository {
    @Autowired
    private Sql2o sql2o;

    /**
     * This method gets all the tasks with abilities from the database.
     * @return List<Task_Ability>
     * */
    @Override
    public List<Task_Ability> getAllTasksAbilities() {
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM \"Task_Ability\"")
                    .executeAndFetch(Task_Ability.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * This method get all the tasks with abilities given an id.
     * @param id
     * @return List<Task_Ability>
     * */
    @Override
    public List<Task_Ability> getTaskAbilityById(Integer id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM \"Task_Ability\" WHERE id_task_ability = :id")
                    .addParameter("id_task_ability", id)
                    .executeAndFetch(Task_Ability.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * This method creates a task with an ability and puts it on the database.
     * @param taskAbility
     * @return Task_Ability
     * */
    @Override
    public Task_Ability createTaskAbility(Task_Ability taskAbility) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO \"Task_Ability\" (id_task, id_ability)"+
                            "values (:taskID, :abilityID)")
                    .addParameter("taskID", taskAbility.getId_task())
                    .addParameter("abilityID", taskAbility.getId_ability())
                    .executeUpdate().getKey();
            return taskAbility;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * This method edits a
     * */
    @Override
    public Task_Ability editTaskAbility(Task_Ability taskAbility) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE \"Task_Ability\" SET id_task = :taskID, id_ability = :abilityID WHERE id_task_ability = :id_task_ability")
                    .addParameter("id_task_ability", taskAbility.getId_task_ability())
                    .addParameter("taskID", taskAbility.getId_task())
                    .addParameter("abilityID", taskAbility.getId_ability())
                    .executeUpdate();
            return taskAbility;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteTaskAbilityById(Integer id) {
        int deletedTaskAbility;
        try(Connection conn = sql2o.open()){
            deletedTaskAbility = conn.createQuery("DELETE FROM \"Task_Ability\" WHERE id_task_ability = :id")
                    .addParameter("id_task_ability", id)
                    .executeUpdate().getResult();
        }
        return deletedTaskAbility == 1;
    }

    @Override
    public boolean deleteAllTasksAbilities() {
        try(Connection conn = sql2o.open()){
            conn.createQuery("TRUNCATE \"Task_Ability\" CASCADE")
                    .executeUpdate().getResult();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}

