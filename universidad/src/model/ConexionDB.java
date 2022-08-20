package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    //ATRIBUTOS
    private Connection conexion;
    //CONSTRUCTOR
    public ConexionDB(){
        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:UniversidadBD");
            if(conexion != null){
                System.out.println("Conexion realizada");
            }
        } catch(SQLException e){ 
            e.printStackTrace();
        }
    }
    //GETTER
    public Connection getConexion(){
        return conexion;
    }
    //ACCIONES
    public void cerrarConexion() throws SQLException{
        conexion.close();
        System.out.println("Conexion cerrada");
    }
}
