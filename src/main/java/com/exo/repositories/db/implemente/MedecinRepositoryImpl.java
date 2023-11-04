package com.exo.repositories.db.implemente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.exo.entities.Medecin;
import com.exo.entities.RendezVous;
import com.exo.repositories.core.DataBase;
import com.exo.repositories.db.MedecinRepository;

public class MedecinRepositoryImpl implements MedecinRepository{
    private DataBase dataBase;
    private final String SQL_INSERT="INSERT INTO `personne`(`id`, `nom`, `prenom`, `tel`,`type`, `specialite`) VALUES (NULL, ?, ?, ?, ?, ?)";
    private final String SQL_FIND_ALL="SELECT id,nom,prenom,tel,type,specialite FROM personne WHERE type=?";
    private final String SQL_FIND_ID="SELECT id,nom,prenom,tel,type,specialite FROM personne WHERE id=? and type=?";
 

    public MedecinRepositoryImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public int insert(Medecin data) {
        int nbrLigne=0;
        System.out.println(data.toString());
        try {     
            dataBase.openConnection();
            dataBase.preparedStatement(SQL_INSERT);
            dataBase.getPs().setString(1, data.getNom());
            dataBase.getPs().setString(2, data.getPrenom());
            dataBase.getPs().setString(3, data.getTel());
            dataBase.getPs().setString(4, data.getType());
            dataBase.getPs().setString(5, data.getSpecialite());   
            nbrLigne=dataBase.executeUpdate();
            dataBase.getPs().close();
            dataBase.closeConnection();
        }
        catch (SQLException e) {
            System.out.printf("Erreur execution de request insert %s", MedecinRepositoryImpl.class);
        }
        return nbrLigne;
    }

     @Override
    public Medecin findById(int id) {
        Medecin med=null;
          try {
            dataBase.openConnection();
            dataBase.preparedStatement(SQL_FIND_ID);
            dataBase.getPs().setInt(1,id);
            dataBase.getPs().setString(2,"medecin");
            ResultSet rs= dataBase.executeSelect();
            if(rs.next()){
                med=new Medecin(rs.getInt("id"),
                                rs.getString("nom"),
                                rs.getString("prenom"),
                                rs.getString("tel"),
                                rs.getString("type"),
                                rs.getString("specialite"),
                                "disponible");
            }
            dataBase.closeConnection();
            dataBase.getPs().close();
            rs.close();      
        }
        catch (SQLException e) {
            System.out.printf("Erreur execution de request findBy %s", MedecinRepositoryImpl.class);
        }
        return med;
    }

    @Override
    public ArrayList<Medecin> findAll() {
        ArrayList<Medecin> medecins = new ArrayList<>();
        try {
            dataBase.openConnection();
            dataBase.preparedStatement(SQL_FIND_ALL);
            dataBase.getPs().setString(1,"medecin");
            ResultSet rs= dataBase.executeSelect();
            while(rs.next()){
                Medecin medecin=new Medecin(rs.getInt("id"),
                                            rs.getString("nom"),
                                            rs.getString("prenom"),
                                            rs.getString("tel"),
                                            rs.getString("type"),
                                            rs.getString("specialite"),
                                            "disponible");
                medecins.add(medecin);
            }
            dataBase.closeConnection();
            dataBase.getPs().close();
            rs.close();
        } catch (SQLException e) {
             System.out.printf("Erreur execution de request find %s", MedecinRepositoryImpl.class);
        }
        
        return medecins;
    }

    @Override
    public int update(Medecin data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
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
