package com.example.voluntariado.repositories;


import com.example.voluntariado.models.Voluntary;

import java.util.List;

/*
 * This interface class represents the voluntary repository.
 * */
public interface VoluntaryRepository {
    public List<Voluntary> getAllVoluntaries();
    public List<Voluntary> getVoluntaryByRut(String rut);
    public int countVoluntary();
    public Voluntary createVoluntary(Voluntary voluntary);
    public Voluntary editVoluntary(Voluntary voluntary);
    public boolean deleteVoluntaryById(Integer id);
    public boolean deleteAllVoluntaries();
}
