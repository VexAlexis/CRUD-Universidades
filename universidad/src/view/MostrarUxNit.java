package view;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

import controller.UniversidadController;
import model.ConexionDB;

public class MostrarUxNit extends JFrame{
    //ATRIBUTOS
    private JPanel panel;
    private JPanel panel2;
    private JTextField texto;
    private UniversidadController uController;
    private ConexionDB conn;
    private String nit;
    private String nombre;
    private String direccion;
    private String email;

    //CONSTRUCTOR
    public MostrarUxNit(ConexionDB conn, UniversidadController uController){
        
        this.uController = uController;
        setTitle("Universidad por Nit");
        setBounds(150,150,1100,600);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        getContentPane().setBackground(new ColorUIResource(135,230,255));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
    }

    //Inicializar elementos
    public void init(){
        panel();
        encabezado();
        panel2();
        botones();
    }

    public void panel(){
        panel = new JPanel();
        getContentPane().add(panel);        
        panel.setLayout(null); 
        panel.setBounds(20,20,1040,525);
        panel.setBackground(new ColorUIResource(53,162,200)); 
    }

    public void encabezado(){
        JLabel titulo = new JLabel("BUSCAR UNIVERSIDAD POR EL NIT: ");
        panel.add(titulo);
        titulo.setLayout(null);
        titulo.setBounds(275, 16, 370, 60);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(Color.WHITE);
        //titulo.setOpaque(true);
        //titulo.setBackground(Color.BLACK);
        titulo.setFont(new FontUIResource("Verdana", Font.BOLD, 18));
        titulo.setHorizontalAlignment(JLabel.CENTER);

        texto = new JTextField();
        panel.add(texto);
        texto.setLayout(null);
        texto.setBounds(645, 33, 120, 30);
        texto.setText("");
        texto.setFont(new FontUIResource("Verdana", Font.BOLD, 18));
        texto.setForeground(Color.WHITE);
        texto.setBackground(new ColorUIResource(53,162,200));
        texto.setBorder(new LineBorder(Color.BLACK,0));

        JLabel raya = new JLabel();
        panel.add(raya);
        raya.setLayout(null);
        raya.setBounds(645, 63, 150, 2);
        raya.setOpaque(true);
        raya.setBackground(new ColorUIResource(50,230,255));
    }

    public void panel2(){
        panel2 = new JPanel();
        panel.add(panel2);        
        panel2.setLayout(null); 
        panel2.setBounds(120,95,800,300);
        panel2.setBackground(new ColorUIResource(125,215,255));

        KeyListener evento = new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                //test.setText(texto.getText());
                
            }
            @Override
            public void keyPressed(KeyEvent e) {                
                //test.setText(texto.getText());
                
            }
            @Override
            public void keyReleased(KeyEvent e) {
                nit = texto.getText();
                ResultSet rs = uController.obtenerUxNit(nit);
                try {
                    if(rs.next()){
                        nit = rs.getString("nit");
                        nombre = rs.getString("nombre");
                        direccion = rs.getString("direccion");
                        email = rs.getString("email");
                        //test.setText(nit+"\n"+nombre+"\n"+direccion+"\n"+email+"\n");
                        infoUni();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }                
            }
        };            
        texto.addKeyListener(evento);
    }

    public void infoUni(){

        JPanel panel3 = new JPanel();
        panel2.add(panel3);        
        panel3.setLayout(null);  
        panel3.setBounds(100,30,600,240);
        panel3.setBackground(new ColorUIResource(53,162,200));

        JLabel nombreJL = new JLabel();
        panel3.add(nombreJL);
        nombreJL.setLayout(null);
        nombreJL.setBounds(50, 10, 500, 30);
        nombreJL.setText(nombre);
        nombreJL.setHorizontalAlignment(SwingConstants.CENTER);
        nombreJL.setFont(new FontUIResource("Verdana", Font.BOLD, 18));
        nombreJL.setForeground(Color.WHITE);
        // nombreJL.setOpaque(true);
        // nombreJL.setBackground(new Color(53,162,200));

        JLabel nitJL = new JLabel();
        panel3.add(nitJL);
        nitJL.setLayout(null);
        nitJL.setBounds(50, 60, 500, 30);
        nitJL.setText("Nit            : "+nit);
        nitJL.setHorizontalAlignment(SwingConstants.LEFT);
        nitJL.setFont(new FontUIResource("Verdana", Font.BOLD, 18));
        nitJL.setForeground(Color.WHITE);
        // nitJL.setOpaque(true);
        // nitJL.setBackground(new Color(53,162,200));

        JLabel emailJL = new JLabel();
        panel3.add(emailJL);
        emailJL.setLayout(null);
        emailJL.setBounds(50, 110, 500, 30);
        emailJL.setText("Email        : "+email);
        emailJL.setHorizontalAlignment(SwingConstants.LEFT);
        emailJL.setFont(new FontUIResource("Verdana", Font.BOLD, 18));
        emailJL.setForeground(Color.WHITE);
        // emailJL.setOpaque(true);
        // emailJL.setBackground(new Color(53,162,200));

        JTextArea direccionJL = new JTextArea();
        panel3.add(direccionJL);
        direccionJL.setLayout(null);
        direccionJL.setBounds(50, 160, 500, 70);
        direccionJL.setText("Direccion : "+direccion);
        direccionJL.setLineWrap(true);
        //direccionJL.setHorizontalAlignment(SwingConstants.LEFT);
        direccionJL.setFont(new FontUIResource("Verdana", Font.BOLD, 18));
        direccionJL.setForeground(Color.WHITE);
        direccionJL.setOpaque(true);
        direccionJL.setBackground(new Color(53,162,200));
        // direccionJL.setEditable(true);
    }


    public void botones(){
        JButton btnAtras = new JButton("Atras");
        panel.add(btnAtras);
        btnAtras.setBounds(290, 440, 200, 40);
        btnAtras.setForeground(Color.white);
        btnAtras.setBackground(new Color(125,215,255));
        btnAtras.setFont(new Font("Verdana", Font.BOLD, 18));
        btnAtras.setBorder(new LineBorder(Color.BLACK,0));
        
        JButton btnSalir = new JButton("Salir");
        panel.add(btnSalir);
        btnSalir.setBounds(550, 440, 200, 40);
        btnSalir.setForeground(Color.white);
        btnSalir.setBackground(new Color(125,215,255));
        btnSalir.setFont(new Font("Verdana", Font.BOLD, 18));
        btnSalir.setBorder(new LineBorder(Color.BLACK,0));

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
