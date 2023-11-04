package com.exo.repositories.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataBaseImpl implements DataBase{
    protected  String driver;
    protected  String url;
    protected  String user;
    protected  String password;
    protected Connection connection =null;
    protected PreparedStatement ps;


    @Override
    public void openConnection() {
        try {
            Class.forName(driver);
            connection=DriverManager.getConnection(url,user, password);
        } 
        catch (SQLException | ClassNotFoundException e) {
            System.out.printf("Erreur de chargement de driver %s",DataBaseImpl.class);
        }
    }

    @Override
    public void closeConnection() {
        if (connection!=null) {
            try {
              this.connection.close();  
            } catch (SQLException e) {
               System.out.printf("Erreur de fermerture %s", DataBaseImpl.class);
            }
           
        }
    }

    @Override
    public ResultSet executeSelect() {
        ResultSet rs=null;
        try {
            // ps= connection.prepareStatement(sql);
            rs=ps.executeQuery();
        } catch (SQLException e) {
           System.out.printf("Erreur de executeSelect %s", DataBaseImpl.class);
        }
        return rs;
    }

    @Override
    public int executeUpdate() {
        int nbrLigne=0;
        try {
            // ps=connection.prepareStatement(sql);
            nbrLigne=ps.executeUpdate();
        } catch (SQLException e) {
            System.out.printf("Erreur de executeUpdate %s", DataBaseImpl.class);
        }
        return nbrLigne;
    }

    @Override
    public PreparedStatement getPs() {
        return ps;
    }

    @Override
    public PreparedStatement preparedStatement(String sql) {
        try {
            ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
    
}
