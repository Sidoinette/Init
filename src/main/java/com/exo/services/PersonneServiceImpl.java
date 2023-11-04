package com.exo.services;

import java.util.ArrayList;

import com.exo.entities.Medecin;
import com.exo.entities.Patient;
import com.exo.entities.Personne;
import com.exo.repositories.core.Repository;

public class PersonneServiceImpl implements PersonneService{

    // 
    private Repository<Patient> patienRepository;
    private Repository<Medecin> medRepository;

    public PersonneServiceImpl(Repository<Patient> patienRepository,Repository<Medecin> medRepository){
        this.patienRepository = patienRepository;
        this.medRepository = medRepository;
    }

    @Override
    public int add(Personne data) {
        // if(data.getType()=="patient"){
        //     return patienRepository.insert(data);
        // }else{

        // }
        return 0;
    }

    @Override
    public ArrayList<Personne> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public int update(Personne data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Personne show(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'show'");
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
