package com.example.voluntariado.repositories;

import com.example.voluntariado.models.Institution;

import java.util.List;

public interface InstitutionRepository {
    public List<Institution> getAllInstitutions();
    public Institution getInstitutionById(Integer id);
    public Institution createInstitution(Institution institution);
    public Institution editInstitution(Institution institution);
    public boolean deleteInstitutionById(Integer id);
    public boolean deleteAllInstitutions();
}
