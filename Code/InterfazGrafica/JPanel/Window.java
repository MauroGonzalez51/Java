package Code.InterfazGrafica.JPanel;

import javax.swing.JFrame;

public class Window extends JFrame {
    public Window() {
        this.setTitle("Random");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}
