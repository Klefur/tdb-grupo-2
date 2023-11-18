package com.example.voluntariado.services;

import com.example.voluntariado.models.Voluntary;
import com.example.voluntariado.repositories.VoluntaryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class VoluntaryService {
    private final VoluntaryRepository voluntaryRepository;

    VoluntaryService(VoluntaryRepository voluntaryRepository){
        this.voluntaryRepository = voluntaryRepository;
    }

    @GetMapping("/voluntaries")
    public List<Voluntary> getAllVoluntaries() {
        return voluntaryRepository.getAllVoluntaries();
    }

    @GetMapping("/voluntaries/{rut}")
    public List<Voluntary> getVoluntaryByRut(@PathVariable("rut") String rut) {
        return voluntaryRepository.getVoluntaryByRut(rut);
    }

    @GetMapping("/voluntaries/count")
    public String countVoluntary(){
        int total = voluntaryRepository.countVoluntary();
        return String.format("Tienes %s Voluntarios", total);
    }

    @PostMapping("/voluntaries")
    @ResponseBody
    public Voluntary createVoluntary(@RequestBody Voluntary voluntary){
        return voluntaryRepository.createVoluntary(voluntary);
    }

    @PutMapping("/voluntaries/{rut}")
    @ResponseBody
    public String editVoluntary(@PathVariable("rut") String rut, @RequestBody Voluntary voluntary){
        voluntary.setRut(rut);
        boolean result = voluntaryRepository.editVoluntary(voluntary);
        if (result){
            return "Edited voluntary";
        }else{
            return "Voluntary not found";
        }
    }

    @DeleteMapping("/voluntaries/{id_voluntary}")
    public String deleteVoluntaryAbility(@PathVariable("id_voluntary") int id_voluntary){
        boolean result = voluntaryRepository.deleteVoluntaryById(id_voluntary);
        if(result){
            return "Deleted Voluntary";
        }
        else{
            return "Voluntary not found";
        }
    }

    @DeleteMapping("/voluntaries")
    public String deleteAllVoluntaries(){
        boolean result = voluntaryRepository.deleteAllVoluntaries();
        if(result){
            return "Deleted voluntaries";
        }else{
            return "Not deleted";
        }
    }

    @GetMapping("/voluntaries/location/{id_emergency}/{radius}")
    public List<Voluntary> findVoluntariesByLocationNear(@PathVariable("id_emergency") Integer id_emergency, @PathVariable Double radius){
        return voluntaryRepository.findVoluntariesByLocationNear(id_emergency, radius);
    }

}
