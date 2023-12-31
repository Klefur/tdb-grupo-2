package com.example.voluntariado.repositories;

import com.example.voluntariado.models.Institution;

import java.util.List;

/*
 * This interface class represents the institution repository.
 * */
public interface InstitutionRepository {
    public List<Institution> getAllInstitutions();
    public List<Institution> getInstitutionById(Integer id);
    public Institution createInstitution(Institution institution);
    public boolean editInstitution(Institution institution);
    public boolean deleteInstitutionById(Integer id);
    public boolean deleteAllInstitutions();
}
