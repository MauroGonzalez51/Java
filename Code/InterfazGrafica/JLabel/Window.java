package Code.InterfazGrafica.JLabel;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
// import java.awt.Color;

public class Window extends JFrame {
    public Window() {
        this.setTitle("Random");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(200, 200));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        startComponents();
    }

    private void startComponents() {
        JPanel panel = new JPanel();

        // ! Quitandole el layout por defecto al panel
        panel.setLayout(null);

        this.getContentPane().add(panel);

        // * Creamos una etiqueta de texto
        // ! El tipo de etiqueta esta dada por el constructor que usemos :O
        JLabel label = new JLabel("Hola");

        label.setBounds(10, 10, 50 , 30);

        // label.setText("String") > En caso de usar el constructor por defecto
        panel.add(label);
    }
}
