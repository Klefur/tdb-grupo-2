package com.example.voluntariado.services;

import com.example.voluntariado.models.Emergency;
import com.example.voluntariado.repositories.EmergencyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EmergencyService {
    private final EmergencyRepository emergencyRepository;

    EmergencyService(EmergencyRepository emergencyRepository){
        this.emergencyRepository = emergencyRepository;
    }

    @GetMapping("/emergencies")
    public List<Emergency> getAllEmergencies(){
        return emergencyRepository.getAllEmergencies();
    }

    @GetMapping("/emergencies/{id_emergency}")
    public List<Emergency> getEmergencyById(@PathVariable("id_emergency") Integer id_emergency){
        return emergencyRepository.getEmergencyById(id_emergency);
    }

    @PostMapping("/emergencies")
    @ResponseBody
    public Emergency createEmergency(@RequestBody Emergency emergency){
        return emergencyRepository.createEmergency(emergency);
    }

    @PutMapping("/emergencies/{id_emergency}")
    @ResponseBody
    public String editEmergency(@PathVariable("id_emergency") Integer id_emergency, @RequestBody Emergency emergency){
        emergency.setId_emergency(id_emergency);
        boolean result = emergencyRepository.editEmergency(emergency);
        if(result){
            return "Edited emergency";
        }else{
            return "Emergency not found";
        }
    }

    @DeleteMapping("/emergencies/{id_emergency}")
    public String deleteEmergency(@PathVariable("id_emergency") int id_emergency){
        boolean result =emergencyRepository.deleteEmergencyById(id_emergency);
        if(result){
            return "Edited Emergency  ";
        }
        else{
            return "Emergency not found";
        }
    }
}
