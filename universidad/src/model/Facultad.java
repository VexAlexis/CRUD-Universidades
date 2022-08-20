package model;

public class Facultad {
    //ATRIBUTOS
    private String codigo;
    private String nombre;
    //CONSTRUCTOR
    public Facultad(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    //GETTERS & SETTERS
    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
