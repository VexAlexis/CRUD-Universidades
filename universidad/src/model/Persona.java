package model;
import java.util.ArrayList;

public class Persona{
    //ATRIBUTOS
    private String nombre;
    private String apellido;
    private int edad;
    private String cedula;
    private char sexo;
    private ArrayList<String> telefonos;
    //CONSTRUCTOR
    public Persona(String nombre, String apellido, int edad, String cedula, char sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cedula = cedula;
        this.sexo = sexo;
        this.telefonos = new ArrayList<String>();
    }
    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public ArrayList<String> getTelefonos() {
        return telefonos;
    }
    public void setTelefonos(ArrayList<String> telefonos) {
        this.telefonos = telefonos;
    }
    

}