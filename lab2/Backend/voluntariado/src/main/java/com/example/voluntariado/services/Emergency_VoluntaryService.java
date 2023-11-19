package com.example.voluntariado.services;

import com.example.voluntariado.models.Emergency;
import com.example.voluntariado.models.Emergency_Voluntary;
import com.example.voluntariado.models.Voluntary;
import com.example.voluntariado.repositories.Emergency_VoluntaryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
public class Emergency_VoluntaryService {
    private final Emergency_VoluntaryRepository emergencyVoluntaryRepository;

    Emergency_VoluntaryService(Emergency_VoluntaryRepository emergencyVoluntaryRepository){
        this.emergencyVoluntaryRepository = emergencyVoluntaryRepository;
    }

    @GetMapping("/emergencies_voluntaries")
    public List<Emergency_Voluntary> getAllEmergenciesVoluntaries(){
        return emergencyVoluntaryRepository.getAllEmergenciesVoluntaries();
    }

    @GetMapping("/emergencies_voluntaries/{id}")
    public List<Emergency_Voluntary> getEmergencyVoluntaryById(@PathVariable("id") Integer id){
        return emergencyVoluntaryRepository.getEmergencyVoluntaryById(id);
    }

    @PostMapping("/emergencies_voluntaries")
    @ResponseBody
    public Emergency_Voluntary createEmergencyVoluntary(@RequestBody Emergency_Voluntary emergencyVoluntary){
        return emergencyVoluntaryRepository.createEmergencyVoluntary(emergencyVoluntary);
    }

    @PutMapping("/emergencies_voluntaries/{id}")
    public String editEmergencyVoluntary(@PathVariable("id") Integer id, @RequestBody Emergency_Voluntary emergencyVoluntary){
        emergencyVoluntary.setId_emergency_voluntary(id);
        boolean result = emergencyVoluntaryRepository.editEmergencyVoluntary(emergencyVoluntary);
        if(result){
            return "Edited emergency_voluntary";
        }else{
            return "Emergency_voluntary not found";
        }
    }

    @DeleteMapping("/emergencies_voluntaries/{id_em_vo}")
    public String deleteEmergencyVoluntaryById(@PathVariable("id_em_vo") Integer id_em_vo){
        boolean result = emergencyVoluntaryRepository.deleteEmergencyVoluntaryById(id_em_vo);
        if(result){
            return "Deleted emergency_voluntary";
        }else{
            return "Emergency_voluntary not found";
        }
    }

    @DeleteMapping("/emergencies_voluntaries")
    public String deleteAllEmergenciesVoluntaries(){
        boolean result = emergencyVoluntaryRepository.deleteAllEmergenciesVoluntaries();
        if(result){
            return "Deleted emergencies_voluntaries";
        }else{
            return "Not deleted";
        }
    }

    @GetMapping("/emergencies_voluntaries/location/{id_emergency}/{radius}")
    public List<Voluntary> findVoluntariesByLocationNear(@PathVariable("id_emergency") Integer id_emergency, @PathVariable Double radius) {
        return emergencyVoluntaryRepository.findVoluntariesByLocationNear(id_emergency, radius);
    }
}
