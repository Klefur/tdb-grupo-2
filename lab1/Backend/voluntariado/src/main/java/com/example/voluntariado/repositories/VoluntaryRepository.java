package com.example.voluntariado.repositories;


import com.example.voluntariado.models.Voluntary;

import java.util.List;

public interface VoluntaryRepository {
    public List<Voluntary> getAllVoluntaries();
    public List<Voluntary> getVoluntaryById(Integer id);
    public Voluntary createVoluntary(Voluntary voluntary);
    public Voluntary editVoluntary(Voluntary voluntary);
    public boolean deleteVoluntaryById(Integer id);
    public boolean deleteAllVoluntaries();
}
