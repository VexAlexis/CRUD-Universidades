package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.UniversidadController;
import model.ConexionDB;

public class MostrarUnisJFrame extends JFrame{
    //ATRIBUTOS
    private JPanel panel;
    private JTable tabla;
    private DefaultTableModel modelo;
    private UniversidadController uController;
    private ConexionDB conn;

    //CONSTRUCTOR
    public MostrarUnisJFrame(ConexionDB conn, UniversidadController uController){
        this.uController = uController;
        setTitle("LISTADO UNIVERSIDADES");
        setBounds(150,150,1100,600);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        getContentPane().setBackground(new ColorUIResource(135,230,255));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
        
    }

    //Inicializar los componentes
    public void init(){
        panel();
        tabla();
        botones();

    }

    public void panel(){
        panel = new JPanel();
        //Cuando se usa this, nos referimos a la ventana al JFrame
        this.getContentPane().add(panel);        
        panel.setLayout(null);  //Desactivando el diseño    - Al desactivar el diseño toca indicar donde vamos a ubicar los objetos
        panel.setBounds(20,20,1040,525);
        panel.setBackground(new ColorUIResource(53,162,200)); //azul

        JLabel titulo = new JLabel("LISTADO UNIVERSIDADES");
        panel.add(titulo);
        titulo.setLayout(null);
        titulo.setBounds(0, 0, 1040, 60);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(Color.white);
        titulo.setFont(new FontUIResource("Verdana", Font.BOLD, 18));
        titulo.setHorizontalAlignment(JLabel.CENTER);
    }

    public void tabla(){
        //Crear y configurar el modelo de la tabla
        Object columnas[] = new Object[] {"Nit", "Universidad", "Direccion", "Email"};
        TableModel m = new DefaultTableModel(new Object[][]{}, columnas);
        //Crear tabla e indicar el modelo a la tabla
        tabla = new JTable(m);   
        //Capturar el modelo de la tabla y castearlo a defaultTableModel
        modelo = (DefaultTableModel) tabla.getModel();
        JScrollPane scroll = new JScrollPane(tabla);
        //Mostrar datos
        mostrarDatos();
        scroll.setBounds(10,60,1020,325);
        panel.add(scroll,BorderLayout.CENTER);      
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    public void mostrarDatos(){
        ResultSet rs = uController.obtenerUniversidades();
        try {
            while(rs.next()){
                String nit = rs.getString("nit");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String email = rs.getString("email");
                modelo.addRow(new Object[] {nit, nombre, direccion, email});

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void botones(){
        JButton btnAtras = new JButton("Atras");
        panel.add(btnAtras);
        btnAtras.setBounds(290, 425, 200, 40);
        btnAtras.setForeground(Color.white);
        btnAtras.setBackground(new Color(125,215,255));
        btnAtras.setFont(new Font("Verdana", Font.BOLD, 18));
        
        JButton btnSalir = new JButton("Salir");
        panel.add(btnSalir);
        btnSalir.setBounds(550, 425, 200, 40);
        btnSalir.setForeground(Color.white);
        btnSalir.setBackground(new Color(125,215,255));
        btnSalir.setFont(new Font("Verdana", Font.BOLD, 18));



        //Evento BOTON ATRAS
        btnAtras.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                new MenuJFrame(conn, uController);
            }            
        });
        //Evento BOTON SALIR
        btnSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // Se pide una confirmación antes de finalizar el programa
                int option = JOptionPane.showConfirmDialog(
                    null, "¿Estás seguro de que quieres cerrar la aplicación?","Confirmación de cierre", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {                    
                    try {
                        conn = new ConexionDB();
                        if(conn.getConexion() != null){
                            conn.cerrarConexion();
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    System.exit(0);
                }
                
            }            
        });
    }

    
}
