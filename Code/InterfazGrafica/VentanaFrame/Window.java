

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
// import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        this.label.setToolTipText("ON Hovered");
        this.add(label);

        this.textField = new JTextField("");
        this.add(textField);

        this.passwordField = new JPasswordField("");
        this.add(passwordField);

        this.btn = new JButton("Click me");
        this.add(btn);
    }

    private class handleTextFields implements ActionListener {
        public void actionListener(ActionEvent event) {
            final String[] userInput = { null };
            if (event.getSource() == textField) {
                userInput[0] = String.format("TextField: %s%n", textField.getText());
            }

            if (event.getSource() == passwordField) {
                userInput[0] = String.format("PasswordField: %s%n", new String(passwordField.getPassword()));
            }

            JOptionPane.showMessageDialog(null, userInput[0]);
        }
    }
}
