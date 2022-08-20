package controller;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.ConexionDB;
import model.dao.UniversidadDao;

public class UniversidadController {
    //ATRIBUTOS
    private ConexionDB conn;
    private ArrayList<UniversidadDao> universidades;
    //CONSTRUCTOR
    public UniversidadController(ConexionDB conn){
        this.conn = conn;
        this.universidades = new ArrayList<UniversidadDao>();
    }
    //ACCIONES
    public boolean crearUniversidad(String nit, String nombre, String direccion, String email){
        UniversidadDao universidad = new UniversidadDao(nit, nombre, direccion, email);
        boolean insert = universidad.insertU(conn);
        if(insert){
            this.universidades.add(universidad);
        }
        return insert;
    }

    public ResultSet obtenerUniversidades(){
        return UniversidadDao.selectAll(conn);
    }

    public ResultSet obtenerUxNit(String nit){
        return UniversidadDao.selectUxNit(conn, nit);
    }

    public boolean actualizarUniXNit(String nit, String nombre, String direccion, String email){
        return UniversidadDao.updatexNit(conn, nit, nombre, direccion, email);
    }

    public boolean eliminarUni(String nit){
        return UniversidadDao.deletexNit(conn, nit);
    }


}
