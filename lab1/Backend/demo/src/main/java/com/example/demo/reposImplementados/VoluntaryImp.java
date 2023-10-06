package com.example.demo.reposImplementados;

import com.example.demo.modelos.Voluntary;
import com.example.demo.repositorios.VoluntaryRepository;

import java.util.ArrayList;

public class VoluntaryImp implements VoluntaryRepository {
    @Override
    public ArrayList<Voluntary> getAllVoluntaries() {
        return null;
    }

    @Override
    public Voluntary getVoluntaryById(Integer id) {
        return null;
    }

    @Override
    public Voluntary createVoluntary(Voluntary voluntary) {
        return null;
    }

    @Override
    public Voluntary editVoluntary(Voluntary voluntary) {
        return null;
    }

    @Override
    public boolean deleteVoluntaryById(Integer id) {
        return false;
    }

    @Override
    public boolean deleteAllVoluntaries() {
        return false;
    }
}
