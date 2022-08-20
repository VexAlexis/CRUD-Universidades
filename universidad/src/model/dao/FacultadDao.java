package model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.ConexionDB;
import model.Facultad;

public class FacultadDao extends Facultad{

    public FacultadDao(String codigo, String nombre) {
        super(codigo, nombre);
    }
    //CONSULTAS SQL
    //ACCIONES
    public void insert(ConexionDB conn, String nit) {
        try {
            if(conn.getConexion() != null){
                String query = "INSERT INTO facultades(codigo, nombre, universidad_nit) VALUES(?, ?, ?)";
                //PREPARAR LA CONSULTA
                PreparedStatement pst = conn.getConexion().prepareStatement(query);
                pst.setString(1, getCodigo());
                pst.setString(2, getNombre());
                pst.setString(3, nit);
                //EJECUTAR LA CONSULTA
                pst.executeUpdate();
                System.out.println("Facultad creada con exito!");
                conn.cerrarConexion();
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
}
