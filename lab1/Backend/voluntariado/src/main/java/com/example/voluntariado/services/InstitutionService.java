package com.example.voluntariado.services;

import com.example.voluntariado.models.Institution;
import com.example.voluntariado.repositories.InstitutionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class InstitutionService {
    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository){
        this.institutionRepository = institutionRepository;
    }

    @GetMapping("/institutions")
    public List<Institution> getAllInstitutions(){
        return institutionRepository.getAllInstitutions();
    }

    @GetMapping("/institutions/{id_institution}")
    public List<Institution> getInstitutionById(@PathVariable("id_institution") Integer id_institution){
        return institutionRepository.getInstitutionById(id_institution);
    }

    @PostMapping("/institutions")
    @ResponseBody
    public Institution createInstitution(@RequestBody Institution institution){
        return institutionRepository.createInstitution(institution);
    }

    @PutMapping("/institutions/{id_institution}")
    @ResponseBody
    public String editInstitution(@PathVariable("id_institution") Integer id_institution, @RequestBody Institution institution){
        institution.setId_institution(id_institution);
        boolean result = institutionRepository.editInstitution(institution);
        if(result){
            return "Edited Institution";
        }else{
            return "Institution not found";
        }
    }

    @DeleteMapping("/institutions/{id_institution}")
    @ResponseBody
    public String deleteInstitutionById(@PathVariable("id_institution") Integer id_institution){
        boolean result = institutionRepository.deleteInstitutionById(id_institution);
        if(result){
            return "Deleted Institution";
        }else{
            return "Institution not found";
        }
    }
}
