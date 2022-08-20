package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

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

public class ActualizarJFrame extends JFrame{
    //ATRIBUTOS
    private UniversidadController uController;
    private ConexionDB conn;
    private JPanel panel;
    private JPanel panel2;
    private JPanel panel3;
    private JTextField texto;
    private String nit;
    private String nombre;
    private String direccion;
    private String email;
    private JLabel nombreJL;
    private JTextField nombreJT;
    private JTextArea direccionJTA;
    private JTextField emailJtxF;
    private JTextField nitJtxF;

    //CONSTRUCTOR
    public ActualizarJFrame(UniversidadController uController){
        this.uController = uController;

        setTitle("Actualizar Universidad");
        setBounds(150,150,1100,660);
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
        panelx2();
        panelx3();
        eventRellenar(); 
        btnAct();
        botones();

    }

    public void panel(){
        panel = new JPanel();
        getContentPane().add(panel);        
        panel.setLayout(null); 
        panel.setBounds(10,10,1065,602);
        panel.setBackground(new ColorUIResource(53,162,200));
    }

    public void encabezado(){
        JLabel titulo = new JLabel("ACTUALIZAR UNIVERSIDAD POR NIT :");
        panel.add(titulo);
        titulo.setLayout(null);
        titulo.setBounds(200, 16, 390, 60);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(Color.WHITE);
        //titulo.setOpaque(true);
        //titulo.setBackground(Color.BLACK);
        titulo.setFont(new Font("Verdana", Font.BOLD, 18));
        titulo.setHorizontalAlignment(JLabel.CENTER);

        texto = new JTextField();
        panel.add(texto);
        texto.setLayout(null);
        texto.setBounds(605, 33, 190, 30);
        texto.setText("");
        texto.setFont(new Font("Verdana", Font.BOLD, 18));
        texto.setForeground(Color.WHITE);
        texto.setBackground(new ColorUIResource(53,162,200));
        texto.setBorder(new LineBorder(Color.BLACK,0));

        JLabel raya = new JLabel();
        panel.add(raya);
        raya.setLayout(null);
        raya.setBounds(600, 63, 200, 2);
        raya.setOpaque(true);
        raya.setBackground(new ColorUIResource(50,230,255));
    }

    public void panelx2(){
        panel2 = new JPanel();
        panel.add(panel2);        
        panel2.setLayout(null); 
        panel2.setBounds(120,95,800,390);
        //panel2.setBackground(new ColorUIResource(53,162,200));
        panel2.setBackground(new ColorUIResource(125,215,255));
    }

    public void eventRellenar(){
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
                    while(rs.next()){
                        nit = rs.getString("nit");
                        nombre = rs.getString("nombre");
                        direccion = rs.getString("direccion");
                        email = rs.getString("email");
                        System.out.println(nit+"\n"+nombre+"\n"+direccion+"\n"+email+"\n"); //test.setText(nit+"\n"+nombre+"\n"+direccion+"\n"+email+"\n"
                        nombreJT.setText(nombre);    
                        nitJtxF.setText(nit); 
                        direccionJTA.setText(direccion);
                        emailJtxF.setText(email);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        };            
        texto.addKeyListener(evento);
    }


    public void panelx3(){
        panel3 = new JPanel();
        panel2.add(panel3);        
        panel3.setLayout(null);  
        panel3.setBounds(100,30,600,330);
        panel3.setBackground(new ColorUIResource(53,162,200));        
        //eventRellenar(); 
        //btnAct();
        infoUni();       
    }

    public void infoUni(){

        nombreJL = new JLabel();
        panel3.add(nombreJL);
        nombreJL.setLayout(null);
        nombreJL.setBounds(50, 10, 250, 30);
        nombreJL.setText("Nombre    :");
        nombreJL.setForeground(Color.WHITE);
        nombreJL.setHorizontalAlignment(SwingConstants.LEFT);
        nombreJL.setFont(new FontUIResource("Verdana", Font.BOLD, 18));

        nombreJT = new JTextField();
        panel3.add(nombreJT);
        nombreJT.setLayout(null);
        nombreJT.setBounds(170, 10, 380, 30);        
        //nombreJT.setText(nombre);
        nombreJT.setBackground(new ColorUIResource(53,162,200));
        nombreJT.setHorizontalAlignment(SwingConstants.LEFT);
        nombreJT.setForeground(Color.WHITE);
        nombreJT.setFont(new FontUIResource("Verdana", Font.BOLD, 18));
        nombreJT.setBorder(new LineBorder(Color.WHITE,1));

        JLabel nitJL = new JLabel();
        panel3.add(nitJL);
        nitJL.setLayout(null);
        nitJL.setBounds(50, 60, 250, 30);
        nitJL.setText("Nit            : ");
        nitJL.setHorizontalAlignment(SwingConstants.LEFT);
        nitJL.setForeground(Color.WHITE);
        nitJL.setFont(new FontUIResource("Verdana", Font.BOLD, 18));
        
        nitJtxF = new JTextField();
        panel3.add(nitJtxF);
        nitJtxF.setLayout(null);
        nitJtxF.setBounds(170, 60, 380, 30);        
        //nitJtxF.setText(nit);
        nitJtxF.setEnabled(false);
        nitJtxF.setBackground(new ColorUIResource(53,162,200));
        nitJtxF.setHorizontalAlignment(SwingConstants.LEFT);
        nitJtxF.setForeground(Color.WHITE);
        nitJtxF.setFont(new FontUIResource("Verdana", Font.BOLD, 18));
        nitJtxF.setBorder(new LineBorder(Color.WHITE,1));

        JLabel emailJL = new JLabel();
        panel3.add(emailJL);
        emailJL.setLayout(null);
        emailJL.setBounds(50, 110, 250, 30);
        emailJL.setText("Email        : ");
        emailJL.setHorizontalAlignment(SwingConstants.LEFT);
        emailJL.setForeground(Color.WHITE);
        emailJL.setFont(new FontUIResource("Verdana", Font.BOLD, 18));

        emailJtxF = new JTextField();
        panel3.add(emailJtxF);
        emailJtxF.setLayout(null);
        emailJtxF.setBounds(170, 110, 380, 30);        
        //emailJtxF.setText(email);
        emailJtxF.setBackground(new ColorUIResource(53,162,200));
        emailJtxF.setHorizontalAlignment(SwingConstants.LEFT);
        emailJtxF.setForeground(Color.WHITE);
        emailJtxF.setFont(new FontUIResource("Verdana", Font.BOLD, 18));
        emailJtxF.setBorder(new LineBorder(Color.WHITE,1));

        JLabel direccionJL = new JLabel();
        panel3.add(direccionJL);
        direccionJL.setLayout(null);
        direccionJL.setBounds(50, 160, 250, 30);
        direccionJL.setText("Direccion : ");
        direccionJL.setHorizontalAlignment(SwingConstants.LEFT);
        direccionJL.setForeground(Color.WHITE);
        direccionJL.setFont(new FontUIResource("Verdana", Font.BOLD, 18));

        direccionJTA = new JTextArea();
        panel3.add(direccionJTA);
        direccionJTA.setLayout(null);
        direccionJTA.setBounds(170, 160, 380, 80);
        //direccionJTA.setText(direccion);
        direccionJTA.setLineWrap(true);
        //direccionJTA.setHorizontalAlignment(SwingConstants.LEFT); -> NO es necesario
        direccionJTA.setFont(new FontUIResource("Verdana", Font.BOLD, 18));
        direccionJTA.setForeground(Color.WHITE);
        direccionJTA.setOpaque(true);
        direccionJTA.setBackground(new Color(53,162,200));
        direccionJTA.setBorder(new LineBorder(Color.WHITE, 1));
        // direccionJTA.setEditable(true);

    }

    public void btnAct(){
        //Boton Actualizar
        JButton btnActualizar = new JButton("Actualizar");
        panel3.add(btnActualizar);
        btnActualizar.setBounds(200, 265, 200, 40);
        btnActualizar.setForeground(Color.white);
        btnActualizar.setBackground(new Color(125,215,255));
        btnActualizar.setFont(new Font("Verdana", Font.BOLD, 18));
        btnActualizar.setBorder(new LineBorder(Color.BLACK,0));

        //Evento BOTON ACTUALIZAR
        btnActualizar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                upDate();                
            }            
        });        
    }
    public void upDate(){
        Boolean upDate = uController.actualizarUniXNit(texto.getText(), nombreJT.getText(), direccionJTA.getText(), emailJtxF.getText());
        if(upDate){
            limpiarCampos();
            JOptionPane.showMessageDialog(null, "Universidad Actualizada con éxito!");
        }else{
            JOptionPane.showMessageDialog(null, "Ocurrió algún Error");
        } 
    }

    public void botones(){

        JButton btnAtras = new JButton("Atras");
        panel.add(btnAtras);
        btnAtras.setBounds(290, 520, 200, 40);
        btnAtras.setForeground(Color.WHITE);
        btnAtras.setBackground(new Color(125,215,255));
        btnAtras.setFont(new Font("Verdana", Font.BOLD, 18));
        btnAtras.setBorder(new LineBorder(Color.BLACK,0));
        
        JButton btnSalir = new JButton("Salir");
        panel.add(btnSalir);
        btnSalir.setBounds(550, 520, 200, 40);
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

    public void limpiarCampos() {
        texto.setText("");
        nitJtxF.setText("");
        nombreJT.setText("");
        emailJtxF.setText("");
        direccionJTA.setText("");
    }
}
