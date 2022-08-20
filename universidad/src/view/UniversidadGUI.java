package view;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import controller.UniversidadController;

public class UniversidadGUI {
    //ATRIBUTOS
    private UniversidadController uController;
    //CONSTRCUTOR
    public UniversidadGUI(UniversidadController uController){
        this.uController = uController;
    }

    //INTERFAZ
    public void crearUniversidad(){
        String encabezado = "\n\n---------------CREAR UNIVERSIDAD---------------\n";
        encabezado += "Ingrese la siguiente informacion\n";
        //Solicitar datos
        String nit = JOptionPane.showInputDialog(encabezado+"Nit: ");
        String nombre = JOptionPane.showInputDialog(encabezado+"Nombre: ");
        String direccion = JOptionPane.showInputDialog(encabezado+"Direccion: ");
        String email = JOptionPane.showInputDialog(encabezado+"Email: ");
        //Crear Uniersidad
        boolean insert = uController.crearUniversidad(nit, nombre, direccion, email);
        if(insert){
            JOptionPane.showMessageDialog(null, "----Universidad Creada-----");
        }else{
            JOptionPane.showMessageDialog(null, "--Ha ocurrido un problema--");
        }
    }
    //MOSTRAR TODAS LAS UNIVERSIDADES
    public void mostrarUniversidades(){
        ResultSet universidades = uController.obtenerUniversidades();
        try {
            String info = "\n\n---------------LISTADO UNIVERSIDADES---------------\n";
            while(universidades.next()){
                info += "\n**Nombre: " + universidades.getString("nombre")+"**";
                info += "\nNit: " + universidades.getString("nit");
                info += "\nDireccion: " + universidades.getString("direccion");
                info += "\nEmail: " + universidades.getString("email");
                info += "\n---------------------------------------------------\n";
            }
            JOptionPane.showMessageDialog(null, info);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarUxNit(){
        //Encabezado
        String info = "\n\n------------CONSULTAR UNIVERSIDAD X NIT------------\n";
        String nit = JOptionPane.showInputDialog(null, "Nit: ");
        //Obtener la universidad
        ResultSet universidadSet = uController.obtenerUxNit(nit);
        try {
            if(universidadSet.next()){
                info = "---------------------------------------------------";
                info += "\n**Nombre: " + universidadSet.getString("nombre")+"**";
                info += "\nNit: " + universidadSet.getString("nit");
                info += "\nDireccion: " + universidadSet.getString("direccion");
                info += "\nEmail: " + universidadSet.getString("email");
                info += "\n---------------------------------------------------\n";
                JOptionPane.showMessageDialog(null, info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void actualizarUniXNitView(){
        String encabezado = "\n\n------------ACTUALIZAR UNIVERSIDAD-------------\n";
        encabezado = "Ingrese la siguiente informacion\n";
        //Solicitar datos
        String nit = JOptionPane.showInputDialog(encabezado+"Nit: ");
        String nombre = JOptionPane.showInputDialog(encabezado+"Nombre: ");
        String direccion = JOptionPane.showInputDialog(encabezado+"Direccion: ");
        String email = JOptionPane.showInputDialog(encabezado+"Email: ");
        //ACTUALZIAR UNIVERSIDAD        
        boolean bool = uController.actualizarUniXNit(nit, nombre, direccion, email);
        if(bool){
            JOptionPane.showMessageDialog(null, "----Universidad Actualizada-----");
        }else{
            JOptionPane.showMessageDialog(null, "--Ha ocurrido un problema--");
        }
    }

    public void eliminarUniversidad(){
        String encabezado = "\n\n------------ACTUALIZAR UNIVERSIDAD-------------\n";
        encabezado = "Ingrese la siguiente informacion\n";
        String nit = JOptionPane.showInputDialog(encabezado+"Nit: ");

        boolean bool = uController.eliminarUni(nit);
        if(bool){
            JOptionPane.showMessageDialog(null, "----Universidad Eliminada----");
        }else{
            JOptionPane.showMessageDialog(null, "--Ha ocurrido un problema--");
        }
    }
    
    


    
}
