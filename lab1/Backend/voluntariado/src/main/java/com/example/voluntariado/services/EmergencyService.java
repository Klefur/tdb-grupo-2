package com.example.voluntariado.services;

import com.example.voluntariado.models.Emergency;
import com.example.voluntariado.repositories.EmergencyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
public class EmergencyService {
    private final EmergencyRepository emergencyRepository;

    EmergencyService(EmergencyRepository emergencyRepository){
        this.emergencyRepository = emergencyRepository;
    }

    @GetMapping("/emergencies")
    public List<Emergency> getAllEmergencies(@RequestParam String token){
        return emergencyRepository.getAllEmergencies(token);
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

    @PutMapping("/{id_emergency}/toggle")
    public String toggleEmergencyState(@PathVariable("id_emergency") Integer id_emergency,
                                       @RequestParam("new_state") Integer new_state){
        if(emergencyRepository.toggleEmergencyState(id_emergency, new_state)){
            return "Updated";
        }else{
            return "Not updated";
        }
    }

    @PutMapping("/emergencies/{id_emergency}")
    @ResponseBody
    public String editEmergency(@PathVariable("id_emergency") Integer id_emergency, @RequestBody Emergency emergency, @RequestParam String token){
        emergency.setId_emergency(id_emergency);
        boolean result = emergencyRepository.editEmergency(emergency, token);
        if(result){
            return "Edited emergency";
        }else{
            return "Emergency not found";
        }
    }

    @DeleteMapping("/emergencies/{id_emergency}")
    public String deleteEmergency(@PathVariable("id_emergency") int id_emergency){
        boolean result = emergencyRepository.deleteEmergencyById(id_emergency);
        if(result){
            return "Deleted Emergency";
        }else{
            return "Emergency not found";
        }
    }

    @DeleteMapping("/emergencies")
    public String deleteAllEmergencies(){
        boolean result = emergencyRepository.deleteAllEmergencies();
        if(result){
            return "Deleted emergencies";
        }else{
            return "Not deleted";
        }
    }
}
