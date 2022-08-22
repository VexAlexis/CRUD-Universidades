package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import controller.UniversidadController;
import model.ConexionDB;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.SQLException;

public class MenuJFrame extends JFrame{
    //ATRIBUTOS
    // private ConexionDB conn;
    private JLabel txtTitulo;
    private JButton btnCrear;
    private JButton btnMostrarAll;
    private JButton btnMostrarxNit;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnSalir;
    
    public MenuJFrame(ConexionDB conn, UniversidadController uController){
        //AÑADIR TITULO
        setTitle("REGISTRO DE UNIVERSIDADES");
        setBounds(150,150,1100,740);
        setIconImage(Toolkit.getDefaultToolkit().getImage((getClass().getResource("/util/uniEnLinea.png"))));
        setResizable(true);    //Impedir que pueda cambiar de tamaño
        setLocationRelativeTo(null);    //Se castee en el centro
        //Seter layout que viene por defecto
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(135,230,255));
        //Cerrar ventana, finalziar el programa
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
        //Ventana visible
        setVisible(true);
        //Inicialiazr elementos
        init();


        //Label para poner imagen
        JLabel imagen = new JLabel(new ImageIcon("uni.png"));
        add(imagen);
        imagen.setBounds(20, 321, 1044, 360);


        //MANEJADOR DE EVENTOS
        btnCrear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                new UniversidadJFrame(uController);
            }
        }); 

        btnMostrarAll.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                new MostrarUnisJFrame(conn, uController);
            }
        });

        btnMostrarxNit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                new MostrarUxNit(conn, uController);
            }
        });

        btnActualizar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                new ActualizarJFrame(uController);
            }
        });
        btnEliminar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                new EliminarUniJFrame(uController);
            }
        });

        btnSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // Se pide una confirmación antes de finalizar el programa
                int option = JOptionPane.showConfirmDialog(
                    null, "¿Estás seguro de que quieres cerrar la aplicación?","Confirmación de cierre", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    try {
                        ConexionDB conn = new ConexionDB();
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

    public void init(){
        encabezado();
        btnCrear();
        btnMostrarAll();
        btnMostrarxNit();
        btnActualizar();
        btnEliminar();
        btnSalir();
    }

    public void encabezado(){
        txtTitulo = new JLabel("SOFTWARE PARA UNIVERSIDADES");
        txtTitulo.setBounds(0,0,1084,60);
        txtTitulo.setVerticalAlignment(JLabel.CENTER);
        txtTitulo.setHorizontalAlignment(JLabel.CENTER);
        txtTitulo.setBackground(new Color(53, 162, 200));
        txtTitulo.setFont(new Font("Verdana", Font.BOLD, 18));
        txtTitulo.setForeground(Color.white);
        txtTitulo.setOpaque(true);
        this.add(txtTitulo);
    }

    public void btnCrear(){
        //IZQUIERDA
        btnCrear = new JButton("Crear Universidad");
        btnCrear.setBounds(147, 95, 350, 40);
        btnCrear.setForeground(Color.white);
        btnCrear.setBackground(new Color(53, 162, 200));
        btnCrear.setFont(new Font("Verdana", Font.BOLD, 18));
        btnCrear.setBorder(new LineBorder(Color.BLACK,0));
        this.add(btnCrear);

        MouseListener evento1 = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {                
            }
            @Override
            public void mousePressed(MouseEvent e) {                
            }
            @Override
            public void mouseReleased(MouseEvent e) {                
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnCrear.setForeground(Color.white);
                btnCrear.setBackground(new Color(135,200,240));                
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnCrear.setForeground(Color.white);   
                btnCrear.setBackground(new Color(53, 162, 200));             
            }
        };
        btnCrear.addMouseListener(evento1);
    }

    public void btnMostrarAll(){
        //DERECHA
        btnMostrarAll = new JButton("Mostrar Universidades");
        btnMostrarAll.setForeground(Color.white);
        btnMostrarAll.setBounds(587, 95, 350, 40);
        btnMostrarAll.setBackground(new Color(53, 162, 200));
        btnMostrarAll.setFont(new Font("Verdana", Font.BOLD, 18));
        btnMostrarAll.setBorder(new LineBorder(Color.BLACK,0));
        this.add(btnMostrarAll);

        MouseListener evento1 = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {                
            }
            @Override
            public void mousePressed(MouseEvent e) {                
            }
            @Override
            public void mouseReleased(MouseEvent e) {                
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnMostrarAll.setForeground(Color.white);
                btnMostrarAll.setBackground(new Color(135,200,240));                
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnMostrarAll.setForeground(Color.white);   
                btnMostrarAll.setBackground(new Color(53, 162, 200));             
            }
        };
        btnMostrarAll.addMouseListener(evento1);
    }

    public void btnMostrarxNit(){
        //IZQUIERDA
        btnMostrarxNit = new JButton("Mostrar Universidad x Nit");
        btnMostrarxNit.setBounds(147, 170, 350, 40);
        btnMostrarxNit.setForeground(Color.white);
        btnMostrarxNit.setBackground(new Color(53, 162, 200));
        btnMostrarxNit.setFont(new Font("Verdana", Font.BOLD, 18));
        btnMostrarxNit.setBorder(new LineBorder(Color.BLACK,0));
        this.add(btnMostrarxNit);

        MouseListener evento1 = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {                
            }
            @Override
            public void mousePressed(MouseEvent e) {                
            }
            @Override
            public void mouseReleased(MouseEvent e) {                
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnMostrarxNit.setForeground(Color.white);
                btnMostrarxNit.setBackground(new Color(135,200,240));                
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnMostrarxNit.setForeground(Color.white);   
                btnMostrarxNit.setBackground(new Color(53, 162, 200));             
            }
        };
        btnMostrarxNit.addMouseListener(evento1);
    }

    public void btnActualizar(){
        //DERECHA
        btnActualizar = new JButton("Actualizar Universidad");
        btnActualizar.setBounds(587, 170, 350, 40);
        btnActualizar.setForeground(Color.white);
        btnActualizar.setBackground(new Color(53, 162, 200));
        btnActualizar.setFont(new Font("Verdana", Font.BOLD, 18));
        btnActualizar.setBorder(new LineBorder(Color.BLACK,0));
        this.add(btnActualizar);

        MouseListener evento1 = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {                
            }
            @Override
            public void mousePressed(MouseEvent e) {                
            }
            @Override
            public void mouseReleased(MouseEvent e) {                
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnActualizar.setForeground(Color.white);
                btnActualizar.setBackground(new Color(135,200,240));                
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnActualizar.setForeground(Color.white);   
                btnActualizar.setBackground(new Color(53, 162, 200));             
            }
        };
        btnActualizar.addMouseListener(evento1);
    }

    public void btnEliminar(){
        //IZQUIERDA
        btnEliminar = new JButton("Eliminar Universidad");
        btnEliminar.setBounds(147, 245, 350, 40);
        btnEliminar.setForeground(Color.white);
        btnEliminar.setBackground(new Color(53, 162, 200));
        btnEliminar.setFont(new Font("Verdana", Font.BOLD, 18));
        btnEliminar.setBorder(new LineBorder(Color.BLACK,0));
        this.add(btnEliminar);

        MouseListener evento1 = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {                
            }
            @Override
            public void mousePressed(MouseEvent e) {                
            }
            @Override
            public void mouseReleased(MouseEvent e) {                
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnEliminar.setForeground(Color.white);
                btnEliminar.setBackground(new Color(135,200,240));                
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnEliminar.setForeground(Color.white);   
                btnEliminar.setBackground(new Color(53, 162, 200));             
            }
        };
        btnEliminar.addMouseListener(evento1);
    }

    public void btnSalir(){
        //DERECHA
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(587, 245, 350, 40);
        btnSalir.setForeground(Color.white);
        btnSalir.setBackground(new Color(53, 162, 200));
        btnSalir.setFont(new Font("Verdana", Font.BOLD, 18));
        btnSalir.setBorder(new LineBorder(Color.BLACK,0));
        this.add(btnSalir);

        MouseListener evento1 = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {                
            }
            @Override
            public void mousePressed(MouseEvent e) {                
            }
            @Override
            public void mouseReleased(MouseEvent e) {                
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSalir.setForeground(Color.white);
                btnSalir.setBackground(new Color(135,200,240));                
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnSalir.setForeground(Color.white);   
                btnSalir.setBackground(new Color(53, 162, 200));             
            }
        };
        btnSalir.addMouseListener(evento1);
    }


}
    
