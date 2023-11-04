package com.exo.services;

import java.util.ArrayList;

import com.exo.entities.Medecin;
import com.exo.repositories.core.Repository;

public class MedecinServiceImpl implements MedecinService{
    protected Repository<Medecin> medecinRepository;

    public MedecinServiceImpl(Repository<Medecin> medecinRepository) {
        this.medecinRepository = medecinRepository;
       
    }

    @Override
    public int add(Medecin data) {
        return medecinRepository.insert(data);
    }

    @Override
    public ArrayList<Medecin> getAll() {
        return medecinRepository.findAll();
    }

    @Override
    public int update(Medecin data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Medecin show(int id) {
        return medecinRepository.findById(id);
    }

    @Override
    public int remove(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public int[] remove(int[] ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
    
}
