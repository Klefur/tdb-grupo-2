package com.example.voluntariado.models;

/**
 * This class represents a task.
 */
public class Task {
    private Integer id_task;
    private String name;
    private String description;
    private Integer state;
    private Integer id_emergency;
    private Integer id_institution;

    // Getters and Setters

    /**
     * Gets the ID of a Task.
     * @return Integer
     */
    public Integer getId_task() {
        return id_task;
    }

    /**
     * Sets the ID of a Task.
     * @param id_task
     */
    public void setId_task(Integer id_task) {
        this.id_task = id_task;
    }

    /**
     * Gets the name of a Task.
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of a Task.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of a Task.
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of a Task.
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the state of a Task.
     * @return Integer
     */
    public Integer getState() {
        return state;
    }

    /**
     * Sets the state of a Task.
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * Gets the ID of the emergency associated with a Task.
     * @return Integer
     */
    public Integer getId_emergency() {
        return id_emergency;
    }

    /**
     * Sets the ID of the emergency associated with a Task.
     * @param id_emergency
     */
    public void setId_emergency(Integer id_emergency) {
        this.id_emergency = id_emergency;
    }

    /**
     * Gets the ID of the institution associated with a Task.
     * @return Integer
     */
    public Integer getId_institution() {
        return id_institution;
    }

    /**
     * Sets the ID of the institution associated with a Task.
     * @param id_institution
     */
    public void setId_institution(Integer id_institution) {
        this.id_institution = id_institution;
    }
}
