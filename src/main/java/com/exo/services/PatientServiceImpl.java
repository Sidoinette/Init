package com.exo.services;

import java.util.ArrayList;

import com.exo.entities.Patient;
import com.exo.repositories.core.Repository;

public class PatientServiceImpl implements PatientService{
    // 
    private Repository<Patient> patienRepository;

    public PatientServiceImpl(Repository<Patient> patienRepository){
        this.patienRepository = patienRepository;
    }

    @Override
    public int add(Patient data) {
       return patienRepository.insert(data);
    }

    @Override
    public ArrayList<Patient> getAll() {
        return patienRepository.findAll();
    }

    @Override
    public int update(Patient data) {
        return patienRepository.update(data);
    }
    
    @Override
    public Patient show(int id) {
        return patienRepository.findById(id);
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
