package com.exo.repositories.core;

public class Mysql extends DataBaseImpl{

    public Mysql(){
        this.driver="com.mysql.cj.jdbc.Driver";
        this.url="jdbc:mysql://localhost:3306/gestion_rdv";
    }
   
}
