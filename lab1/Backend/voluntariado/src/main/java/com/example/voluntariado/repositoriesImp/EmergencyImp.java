package com.example.voluntariado.repositoriesImp;

import com.example.voluntariado.models.Emergency;
import com.example.voluntariado.repositories.EmergencyRepository;

import java.util.List;

public class EmergencyImp implements EmergencyRepository {
    @Override
    public List<Emergency> getAllEmergencies() {
        return null;
    }

    @Override
    public Emergency getEmergencyById(Integer id) {
        return null;
    }

    @Override
    public Emergency createEmergency(Emergency emergency) {
        return null;
    }

    @Override
    public Emergency editEmergency(Emergency emergency) {
        return null;
    }

    @Override
    public boolean deleteEmergencyById(Integer id) {
        return false;
    }

    @Override
    public boolean deleteAllEmergencies() {
        return false;
    }
}
