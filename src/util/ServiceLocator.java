package util;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;

public class ServiceLocator {

    private static ServiceLocator instance = null;

    private Connection conexion = null;
    private boolean conexionLibre = true;

    public static ServiceLocator getInstance() {
        if (instance == null) {
            try {
                instance = new ServiceLocator();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return instance;
    }

    private ServiceLocator() throws Exception {
        try {
            String url = "jdbc:postgresql://localhost:5432/CRUD-UD";
            String usuario = "postgres";
            String password = "asd123"; 
            Class.forName("org.postgresql.Driver").newInstance();
            conexion = DriverManager.getConnection(url, usuario, password);
            conexion.setAutoCommit(false);
        } catch (Exception e) {
            throw new CaException("ServiceLocator", "ERROR_CONEXION_BD " + e);
        }
    }

    public synchronized Connection tomarConexion() {
        while (!conexionLibre) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        conexionLibre = false;
        notify();
        return conexion;
    }

    public synchronized void liberarConexion() {
        while (conexionLibre) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        conexionLibre = true;
        notify();
    }

    public void close() {
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit() {
        try {
            conexion.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback() {
        try {
            conexion.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
