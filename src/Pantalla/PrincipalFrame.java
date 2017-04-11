package Pantalla;

import Objetos.Determinante;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PrincipalFrame extends JFrame {

    private final JTextField[][] matriz;
    private final JPanel pnlUnico;
    private final JPanel pnlBoton;
    private final JButton btnCalcular;
    private Determinante determinante;
    Integer solucion = 0;
    private final JPanel pnlArriba;
    private final JLabel lblResultado;

    public PrincipalFrame(Integer tamanoMatriz) {
        super.setSize(400, 400);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.getContentPane().setBackground(Color.WHITE);
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());

        pnlUnico = new JPanel();
        pnlUnico.setLayout(new GridLayout(tamanoMatriz, tamanoMatriz));

        matriz = new JTextField[tamanoMatriz][tamanoMatriz];
        for (int i = 0; i < tamanoMatriz; i++) {
            for (int j = 0; j < tamanoMatriz; j++) {
                matriz[i][j] = new JTextField();
                pnlUnico.add(matriz[i][j]);
            }
        }

        pnlBoton = new JPanel();
        pnlBoton.setBackground(Color.WHITE);
        btnCalcular = new JButton("Calcular");
        determinante = new Determinante();

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int[][] resolverMatriz = new int[tamanoMatriz][tamanoMatriz];

                for (int i = 0; i < tamanoMatriz; i++) {
                    for (int j = 0; j < tamanoMatriz; j++) {
                        resolverMatriz[i][j] = Integer.valueOf(matriz[i][j].getText());
                    }
                }

                solucion = determinante.determinante(resolverMatriz, tamanoMatriz);
                lblResultado.setText("El resultado es: " + solucion);
            }
        });

        pnlBoton.add(btnCalcular);

        pnlArriba = new JPanel();
        lblResultado = new JLabel();
        pnlArriba.add(lblResultado);

        super.add(pnlUnico, BorderLayout.CENTER);
        super.add(pnlBoton, BorderLayout.PAGE_END);
        super.add(pnlArriba, BorderLayout.PAGE_START);
        super.setResizable(false);
        super.setVisible(true);
    }

}
