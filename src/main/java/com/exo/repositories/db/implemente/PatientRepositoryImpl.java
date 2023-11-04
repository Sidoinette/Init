package com.exo.repositories.db.implemente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.exo.entities.Patient;
import com.exo.entities.RendezVous;
import com.exo.repositories.core.DataBase;
import com.exo.repositories.db.PatientRepository;

public class PatientRepositoryImpl implements PatientRepository{
     private DataBase dataBase;
    private final String SQL_INSERT="INSERT INTO `personne`(`id`, `nom`, `prenom`, `tel`, `type`, `antecedents`) VALUES (NULL, ?, ?, ?, ?, ?)";
    private final String SQL_FIND_ID="SELECT `id`, `nom`, `prenom`, `tel`, `type`, `antecedents` FROM personne WHERE id=? and type=?";

    public PatientRepositoryImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public int insert(Patient data) {
        int nbrLigne=0;
        System.out.println(data.toString());
        try {     
            dataBase.openConnection();
            dataBase.preparedStatement(SQL_INSERT);
            dataBase.getPs().setString(1, data.getNom());
            dataBase.getPs().setString(2, data.getPrenom());
            dataBase.getPs().setString(3, data.getTel());
            dataBase.getPs().setString(4, data.getType());
            dataBase.getPs().setString(5, String.join(",",data.getAntecedents()));    
            nbrLigne=dataBase.executeUpdate();
            dataBase.getPs().close();
            dataBase.closeConnection();
        }
        catch (SQLException e) {
            System.out.printf("Erreur execution de request insert %s", PatientRepositoryImpl.class);
        }
        return nbrLigne;
    }

    @Override
    public int update(Patient data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ArrayList<Patient> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Patient findById(int id) {
        Patient p=null;
          try {
            dataBase.openConnection();
            dataBase.preparedStatement(SQL_FIND_ID);
            dataBase.getPs().setInt(1,id);
            dataBase.getPs().setString(2,"patient");
            ResultSet rs= dataBase.executeSelect();
            if(rs.next()){
                p=new Patient(rs.getInt("id"),
                                rs.getString("nom"),
                                rs.getString("prenom"),
                                rs.getString("tel"),
                                rs.getString("tel"));
            }
            dataBase.closeConnection();
            dataBase.getPs().close();
            rs.close();  
        }
        catch (SQLException e) {
             System.out.printf("Erreur execution de request findBy %s", PatientRepositoryImpl.class);
        }
        return p;    
    }

    @Override
    public int delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int indexOf(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public ArrayList<RendezVous> findAll(String d, String h,int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}
