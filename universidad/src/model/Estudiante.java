package model;
public class Estudiante extends Persona{
    //ATRIBUTOS
    private String codigo;
    
    //CONSTRUCTOR
    public Estudiante(String nombre, String apellido, int edad, String cedula, char sexo, String codigo) {
        super(nombre, apellido, edad, cedula, sexo);
        this.codigo = codigo;
    }
    //GETTERS & SETTERS
    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
}
