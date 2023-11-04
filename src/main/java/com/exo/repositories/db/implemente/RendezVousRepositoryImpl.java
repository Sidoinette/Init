package com.exo.repositories.db.implemente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.exo.entities.RendezVous;
import com.exo.repositories.core.DataBase;
import com.exo.repositories.db.RendezVousRepository;

public class RendezVousRepositoryImpl implements RendezVousRepository{
    private DataBase dataBase;
    private final String SQL_INSERT="INSERT INTO `rendezvous`(`id`, `idMed`, `idPatient`, `date`, `heure`, `etat`) VALUES (NULL,?,?,?,?,?)";
    private final String SQL_FIND_D_H="SELECT `id`, `idMed`, `idPatient`, `date`, `heure`, `etat` FROM rendezvous WHERE idMed=? and date=? and heure=?";
    

    public RendezVousRepositoryImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public int insert(RendezVous data) {
        int nbrLigne=0;
        System.out.println(data.toString());
        try {     
            dataBase.openConnection();
            dataBase.preparedStatement(SQL_INSERT);
            dataBase.getPs().setInt(1, data.getMed().getId());
            dataBase.getPs().setInt(2, data.getPatient().getId());
            dataBase.getPs().setString(3, data.getDate());
            dataBase.getPs().setString(4, data.getHeure()); 
            dataBase.getPs().setInt(5, data.getEtat());      
            nbrLigne=dataBase.executeUpdate();
            dataBase.getPs().close();
            dataBase.closeConnection();
        }
        catch (SQLException e) {
            System.out.printf("Erreur execution de request insert %s", RendezVousRepositoryImpl.class);
        }
        return nbrLigne;
    }

     @Override
    public ArrayList<RendezVous> findAll(String d,String h,int id) {
         ArrayList<RendezVous> rdvs = new ArrayList<>();
        try {
            dataBase.openConnection();
            dataBase.preparedStatement(SQL_FIND_D_H);
            dataBase.getPs().setInt(1, id);
            dataBase.getPs().setString(2, d);
             dataBase.getPs().setString(3, h);
            ResultSet rs= dataBase.executeSelect();
            while(rs.next()){
                RendezVous rdv=new RendezVous(rs.getInt("id"),
                                            rs.getString("date"),
                                            rs.getString("heure"),
                                            rs.getInt("etat"));
                rdvs.add(rdv);
            }
            dataBase.closeConnection();
            rs.close();
        } catch (SQLException e) {
           System.out.printf("Erreur execution de request findAll %s", RendezVousRepositoryImpl.class);
        }
        
        return rdvs;
    }

    @Override
    public int update(RendezVous data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ArrayList<RendezVous> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public RendezVous findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
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

    
}
