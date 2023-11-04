package com.exo.repositories.core;

import java.util.ArrayList;

import com.exo.entities.RendezVous;

public interface Repository <T>{
    int insert (T data);
    // int insert (T data,T y,T x,int a);
    int update (T data);
    ArrayList<T> findAll();
    T findById(int id);
    ArrayList<RendezVous> findAll(String d,String h,int id);
    int delete(int id);
    int indexOf(int id);
}
