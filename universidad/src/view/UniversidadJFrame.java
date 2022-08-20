package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

import controller.UniversidadController;
import model.ConexionDB;

import java.awt.Color;
import java.awt.event.*;
public class UniversidadJFrame extends JFrame {

    // ATRIBUTOS
    private JLabel lblNombre;
    private JLabel lblNit;
    private JLabel lblDireccion;
    private JLabel lblEmail;
    private JTextField txtNombre;
    private JTextField txtNit;
    private JTextField txtDireccion;
    private JTextField txtEmail;
    private JButton btnRegistrar;
    private JButton btnAtras;
    private UniversidadController uController;
    private ConexionDB conn;

    //CONSTRUCTOR

    public UniversidadJFrame(UniversidadController uController){
        this.uController = uController;
        //Configurar la ventana del formulario
        setTitle("Formulario de registro");
        setBounds(150,150, 415, 350);        
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        getContentPane().setBackground(new ColorUIResource(135,230,255));
        setVisible(true);        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
        
    }

    //Inicializar elementos en ventana
    public void init(){
        lblNombre = new JLabel("Nombre: ");
        lblNombre.setBounds(10, 10, 80, 30);

        txtNombre = new JTextField();
        txtNombre.setBounds(90, 10, 300, 30);

        lblNit = new JLabel("Nit: ");
        lblNit.setBounds(10, 50, 80, 30);

        txtNit = new JTextField();
        txtNit.setBounds(90, 50, 300, 30);

        lblDireccion = new JLabel("Dirección: ");
        lblDireccion.setBounds(10, 90, 80, 30);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(90, 90, 300, 30);

        lblEmail = new JLabel("Email: ");
        lblEmail.setBounds(10, 130, 80, 30);

        txtEmail = new JTextField();
        txtEmail.setBounds(90, 130, 300, 30);

        btnAtras = new JButton("Atras");
        btnAtras.setBounds(125, 230, 150, 30);
        btnAtras.setForeground(Color.WHITE);
        btnAtras.setBackground(new Color(53,162,200));
        btnAtras.setFont(new FontUIResource("Verdana", FontUIResource.BOLD, 14));

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(125, 190, 150, 30);        
        btnRegistrar.setForeground(Color.white);
        btnRegistrar.setBackground(new Color(53,162,200));
        btnRegistrar.setFont(new FontUIResource("Verdana", FontUIResource.BOLD, 14));

        // Manejador de eventos
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarUniversidad();
            }
        });

        btnAtras.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                new MenuJFrame(conn, uController);
            }            
        });

        // Añadir elementos a la ventana
        add(lblNombre);
        add(txtNombre);
        add(lblNit);
        add(txtNit);
        add(lblDireccion);
        add(txtDireccion);
        add(lblEmail);
        add(txtEmail);
        add(btnRegistrar);
        add(btnAtras);
    }

    public void registrarUniversidad() {
        // Obtener los datos de los campos de texto
        boolean insert = uController.crearUniversidad(txtNit.getText(), txtNombre.getText(), txtDireccion.getText(),
                txtEmail.getText());
        if (insert) {   
            limpiarCampos();         
            JOptionPane.showMessageDialog(this, "Universidad registrada con éxito");            
        } else {
            JOptionPane.showMessageDialog(this, "Ups! algo sucedió por favor intenta mas tarde");
        }
    }

    public void cerrarPrograma(ConexionDB conn){
        try {
            if(conn.getConexion() != null){
                conn.cerrarConexion();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtNit.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
    }

    

}
