package com.example.demo.repositorios;

import com.example.demo.modelos.Voluntary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface VoluntaryRepository {
    public ArrayList<Voluntary> getAllVoluntaries();
    public Voluntary getVoluntaryById(Integer id);
    public Voluntary createVoluntary(Voluntary voluntary);
    public Voluntary editVoluntary(Voluntary voluntary);
    public boolean deleteVoluntaryById(Integer id);
    public boolean deleteAllVoluntaries();
}
