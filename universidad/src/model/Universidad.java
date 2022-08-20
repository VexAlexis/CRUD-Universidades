package model;
import java.util.ArrayList;
import model.dao.FacultadDao;

public class Universidad {
    //ATRIBUTOS
    private String nit;
    private String nombre;    
    private String direccion;
    private String email;
    private ArrayList<String> telefonos;
    private ArrayList<Facultad> facultades;
    //CONSTRUCTOR
    public Universidad(String nit, String nombre, String direccion, String email){
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.email = email;
        this.telefonos = new ArrayList<String>();
        this.facultades = new ArrayList<Facultad>();
    }
    //GETTERS & SETTERS
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNit() {
        return nit;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public ArrayList<String> getTelefonos() {
        return telefonos;
    }
    public void setTelefonos(ArrayList<String> telefonos) {
        this.telefonos = telefonos;
    }
    public ArrayList<Facultad> getFacultades() {
        return facultades;
    }
    public void setFacultades(ArrayList<Facultad> facultades) {
        this.facultades = facultades;
    }
    
    //ACCIONES
    public void crearFacultad(ConexionDB conn, String codigo, String nombre){
        //Crear un objeto de tipo facultad
        FacultadDao objFacultad = new FacultadDao(codigo, nombre);
        objFacultad.insert(conn, getNit());
        facultades.add(objFacultad);
    }
    
}
