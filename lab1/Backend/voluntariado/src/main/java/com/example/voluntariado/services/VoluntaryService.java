package com.example.voluntariado.services;

import com.example.voluntariado.models.Voluntary;
import com.example.voluntariado.repositories.VoluntaryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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
    public List<Voluntary> getVoluntaryById(@PathVariable("rut") String rut) {
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




}
