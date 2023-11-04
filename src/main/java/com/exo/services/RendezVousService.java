package com.exo.services;

import java.util.ArrayList;

import com.exo.entities.RendezVous;

public interface RendezVousService extends IService<RendezVous>{
    ArrayList<RendezVous> show(String d,String h,int id);
}
