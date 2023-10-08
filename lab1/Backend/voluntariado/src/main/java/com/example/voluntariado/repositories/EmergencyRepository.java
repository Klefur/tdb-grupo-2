package com.example.demo.repositorios;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface EmergencyRepository {
    public ArrayList<Emergency> getAllEmergencies();
    public Emergency getEmergencyById(Integer id);
    public Emergency createEmergency(Emergency emergency);
    public Emergency editEmergency(Emergency emergency);
    public boolean deleteEmergencyById(Integer id);
    public boolean deleteAllEmergencies();
}
