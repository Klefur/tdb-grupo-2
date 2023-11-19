package com.example.voluntariado.repositories;

import com.example.voluntariado.models.Emergency_Voluntary;
import com.example.voluntariado.models.Voluntary;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface Emergency_VoluntaryRepository {
    public List<Emergency_Voluntary> getAllEmergenciesVoluntaries();
    public List<Emergency_Voluntary> getEmergencyVoluntaryById(Integer id);
    public Emergency_Voluntary createEmergencyVoluntary(Emergency_Voluntary emergencyVoluntary);
    public boolean editEmergencyVoluntary(Emergency_Voluntary emergencyVoluntary);
    public boolean deleteEmergencyVoluntaryById(Integer id);
    public boolean deleteAllEmergenciesVoluntaries();
    public List<Voluntary> findVoluntariesByLocationNear(Integer id_emergency, Double distance);
}
