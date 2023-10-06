package com.example.demo.repositorios;

import com.example.demo.modelos.Institution;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface InstitutionRepository {
    public ArrayList<Institution> getAllInstitutions();
    public Institution getInstitutionById(Integer id);
    public Institution createInstitution(Institution institution);
    public Institution editInstitution(Institution institution);
    public boolean deleteInstitutionById(Integer id);
    public boolean deleteAllInstitutions();
}
