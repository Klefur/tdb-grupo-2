package com.example.voluntariado.repositories;

import com.example.voluntariado.models.Emergency;

import java.util.List;

/*
 * This interface class represents the emergency repository.
 * */
public interface EmergencyRepository {
    public List<Emergency> getAllEmergencies();
    public List<Emergency> getEmergencyById(Integer id);
    public Emergency createEmergency(Emergency emergency);
    public boolean editEmergency(Emergency emergency);
    public boolean deleteEmergencyById(Integer id);
    public boolean deleteAllEmergencies();
}
