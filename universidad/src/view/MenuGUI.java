package view;

import javax.swing.JOptionPane;
import controller.UniversidadController;

public class MenuGUI {
    //ATRIBUTOS
    private UniversidadController uController;
    //COSNTRUCTOR
    public MenuGUI(UniversidadController uController){
        this.uController = uController;
    }

    public void crearMenu(){
        ;
        UniversidadGUI uGui = new UniversidadGUI(uController);
        String mensaje = "----------------MENU UNIVERSIDADES----------------\n";
        mensaje += "1) Crear universidad\n";
        mensaje += "2) Mostrar Universidades\n";
        mensaje += "3) Consultar Universidad x Nit\n";        
        mensaje += "4) Actualizar Universidad x Nit\n";
        mensaje += "5) Eliminar Universidad\n";
        mensaje += "0) Salir\n";
        int opc = -1;
        try {            
            while(opc != 0){
                opc = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                switch (opc) {
                    case 1:
                        uGui.crearUniversidad();
                        break;
                    case 2:
                        uGui.mostrarUniversidades();
                        break;
                    case 3:
                        uGui.mostrarUxNit();
                        break;
                    case 4:
                        uGui.actualizarUniXNitView();
                        break;
                    case 5:
                        uGui.eliminarUniversidad();
                        break;         
                    default:
                        break;
                }                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "\nPor favor ingrese valores numericos en el menu\n");
        }
    }



}
