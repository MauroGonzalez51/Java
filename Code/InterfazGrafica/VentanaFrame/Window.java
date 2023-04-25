package Code.InterfazGrafica.VentanaFrame;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;

public class Window extends JFrame {
    private JLabel label;
    private  JTextField textField;
    private JPasswordField passwordField;
    private JButton btn;

    public Window() {
        this.setTitle("Test GUI");
        this.setLayout(new FlowLayout());

        Icon imgLabel = new ImageIcon(getClass().getResource());
    }
}
