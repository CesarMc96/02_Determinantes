package Pantalla;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TamañoMatriz extends JFrame {
    
    private final JPanel pnlUnico;
    private final JLabel lblPregunta;
    private final JTextField txtRespuesta;
    private final JButton btnAceptar;
    
    public TamañoMatriz() {
        super.setSize(400, 80);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setTitle("Tamaño Matriz");
        super.getContentPane().setBackground(Color.WHITE);
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());

        //********************
        pnlUnico = new JPanel();
        //pnlUnico.setLayout(new BorderLayout());
        lblPregunta = new JLabel("¿De cuanto sera tu determinante?");
        txtRespuesta = new JTextField(7);
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener((ActionEvent ae) -> {
            PrincipalFrame pf = new PrincipalFrame(Integer.valueOf(txtRespuesta.getText()));
            super.setVisible(false);
        });
        
        pnlUnico.add(lblPregunta);
        pnlUnico.add(txtRespuesta);
        pnlUnico.add(btnAceptar);
        //*********************
        
        super.add(pnlUnico);
        super.setResizable(false);
        super.setVisible(true);
    }
    
}
