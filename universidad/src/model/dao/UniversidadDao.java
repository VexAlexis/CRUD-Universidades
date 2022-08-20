package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ConexionDB;
import model.Universidad;

public class UniversidadDao extends Universidad{

    public UniversidadDao(String nit, String nombre, String direccion, String email) {
        super(nit, nombre, direccion, email);
    }

    //CONSULTAS SQL
    public boolean insertU(ConexionDB conn){
        boolean insert = false;
        try {
            if(conn.getConexion() != null){
                String query = "INSERT INTO universidades VALUES(?, ?, ?, ?)";
                PreparedStatement pst = conn.getConexion().prepareStatement(query);
                pst.setString(1, getNit());
                pst.setString(2, getNombre());
                pst.setString(3, getDireccion());
                pst.setString(4, getEmail());                
                int resp = pst.executeUpdate();
                if(resp ==1){
                    insert = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insert;
    }

    //SELECT TODAS LAS UNIVERSIDADES
    public static ResultSet selectAll(ConexionDB conn){
        ResultSet result = null;
        try {
            String query = "SELECT * FROM universidades";
            result = conn.getConexion().createStatement().executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;        
    }

    //SELECT UNIVERSIDAD POR NIT del ATRIBUTO de esa CLASE (Objeto)
    public ResultSet selectUxNit(ConexionDB conn){
        ResultSet result = null;
        try {
            String query = "SELECT * FROM universidades WHERE nit= ? ";
            PreparedStatement pst = conn.getConexion().prepareStatement(query);
            //Aca el nit hace referencia al atributo
            pst.setString(1, getNit());
            result = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    //SELECT UNIVERSIDAD POR NIT como PARAMETRO
    public static ResultSet selectUxNit(ConexionDB conn, String nit){
        ResultSet result = null;
        try {
            String query = "SELECT * FROM universidades WHERE nit= ? ";
            PreparedStatement pst = conn.getConexion().prepareStatement(query);
            //Aca el nit hace referencia al parametro
            pst.setString(1, nit);
            result = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //UPDATE POR NIT
    public static boolean updatexNit(ConexionDB conn, String nit, String nombre, String direccion, String email){
        boolean resp = false;
        try {
            if(conn.getConexion() != null){
                String query = "UPDATE universidades set nombre=?, direccion=?, email=? WHERE nit=?";
                PreparedStatement pst = conn.getConexion().prepareStatement(query);
                pst.setString(1, nombre);
                pst.setString(2, direccion);
                pst.setString(3, email);            
                pst.setString(4, nit);
                resp = pst.executeUpdate() ==1? true:false;
                System.out.println("Universidad actualizada correctamente");
            }            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resp;
    }

    //DELETE POR NIT
    public static boolean deletexNit(ConexionDB conn, String nit){
        boolean resp = false;
        try {
            if(conn.getConexion() != null){
                String query = "DELETE FROM universidades WHERE nit=?";
                PreparedStatement pst = conn.getConexion().prepareStatement(query);
                pst.setString(1, nit);
                resp = pst.executeUpdate() == 1? true: false;
                System.out.println("Universidad ELIMINADA con Exito!");
                //conn.cerrarConexion();
            }            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resp;
    }





    





}