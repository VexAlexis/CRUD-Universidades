package controller;

import model.ConexionDB;
import view.MenuJFrame;

public class MainController {

    public MainController(){
    //CREAR OBEJTOS
    ConexionDB conn = new ConexionDB();
    UniversidadController uController = new UniversidadController(conn);
    // Menu menu = new Menu(uController);
    // menu.crearMenu();
    // MenuGUI menuGui = new MenuGUI(uController);
    // menuGui.crearMenu();
    new MenuJFrame(conn, uController);


    //CERRAR CONEXION
    try {
        //conn.cerrarConexion();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
}
