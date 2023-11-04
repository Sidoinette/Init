package com.exo.repositories.core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface DataBase {
    void openConnection();
    void closeConnection();
    ResultSet executeSelect();
    int executeUpdate ();
    PreparedStatement getPs();
    PreparedStatement preparedStatement(String sql);
}
