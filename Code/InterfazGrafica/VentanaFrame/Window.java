package Code.InterfazGrafica.VentanaFrame;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
// import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
// import java.awt.event.ActionEvent;

public class Window extends JFrame {
    private JLabel label;
    private  JTextField textField;
    private JPasswordField passwordField;
    private JButton btn;

    public Window() {
        this.setTitle("Test GUI");
        this.setLayout(new FlowLayout());

        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Icon imgLabel = new ImageIcon(getClass().getResource(""));
        this.label = new JLabel("Label con imagenes", imgLabel, SwingConstants.LEFT);
        this.add(label);

        this.textField = new JTextField("XD");
        this.add(textField);

        this.passwordField = new JPasswordField();
        this.add(passwordField);

        this.btn = new JButton("Click me");
        this.add(btn);
    }
}
