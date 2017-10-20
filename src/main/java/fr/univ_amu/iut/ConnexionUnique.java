package fr.univ_amu.iut;

import java.sql.*;

/**
 * Created by t14001551 on 25/09/17.
 */
public class ConnexionUnique {
    private Connection connection;
    private static ConnexionUnique instance = null;
    private static final String CONNECT_URL = "jdbc:mysql://mysql-julietrocme.alwaysdata.net:3306/julietrocme_bd";
    private static final String LOGIN = "144389";
    private static final String PASSWORD = "piloute19952006";

    private ConnexionUnique() {
        try {
            connection = DriverManager.getConnection(CONNECT_URL,LOGIN,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){return connection;}

    public static ConnexionUnique getInstance(){
        if(instance == null)
            instance = new ConnexionUnique();
        return instance;
    }
}
