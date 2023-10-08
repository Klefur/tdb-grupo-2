package com.example.voluntariado.repositories;

import com.example.voluntariado.models.Emergency;

import java.util.List;

public interface EmergencyRepository {
    public List<Emergency> getAllEmergencies();
    public Emergency getEmergencyById(Integer id);
    public Emergency createEmergency(Emergency emergency);
    public Emergency editEmergency(Emergency emergency);
    public boolean deleteEmergencyById(Integer id);
    public boolean deleteAllEmergencies();
}
