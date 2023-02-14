package Code.InterfazGrafica.JPanel;

import javax.swing.JFrame;
import javax.swing.JPanel;
// import java.awt.Color;
import java.awt.Dimension;

public class Window extends JFrame {
    public Window() {
        this.setTitle("Random");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // * Tamaño minimo de la ventana
        this.setMinimumSize(new Dimension(200, 200));

        // ! Cambiamos si la ventana se puede o no cambiar de tamaño
        // !        false > no se puede cambiar el tamaño :O
        // this.setResizable(false);

        // * Color de la ventana
        // this.getContentPane().setBackground(Color.blue);

        startComponents();
    }

    private void startComponents() {

        // * Creacion de un panel :>
        JPanel panel = new JPanel();

        // * Cambiar el color del panel
        // panel.setBackground(Color.green);

        // ! Agregamos el panel a la ventana 
        this.getContentPane().add(panel);
    }
}
