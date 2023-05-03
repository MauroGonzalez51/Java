

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

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

        HandleTextFields handleTextFields = new HandleTextFields();

        this.textField.addActionListener(handleTextFields);
        this.passwordField.addActionListener(handleTextFields);

        HandleBtn handleBtn = new HandleBtn();

        this.btn.addActionListener(handleBtn);
    }

    private class HandleTextFields implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            final String[] userInput = { "" };
            if (event.getSource() == textField) {
                userInput[0] = String.format("TextField: %s%n", textField.getText());
            }

            if (event.getSource() == passwordField) {
                userInput[0] = String.format("PasswordField: %s%n", new String(passwordField.getPassword()));
            }

            JOptionPane.showMessageDialog(null, userInput[0]);

            /* 

            HashMap <Object, Runnable> options = new HashMap <>() {{
                put(textField, () -> {
                    userInput[0] = String.format("TextField: %s%n", textField.getText()); 
                });

                put(passwordField, () -> {
                    userInput[0] = String.format("PasswordField: %s%n", new String(passwordField.getPassword()));
                });

                put("default", () -> {});
            }};

            options.getOrDefault(event.getSource(), options.get("default")).run();

            JOptionPane.showMessageDialog(null, userInput[0]);
            */
        }
    }

    private class HandleBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            final String[] userInput = { "" };

            userInput[0] = String.format("Btn pressed: %s%n", event.getActionCommand());

            JOptionPane.showMessageDialog(Window.this, userInput[0]);

            String user = textField.getText();
            String password = new String(passwordField.getPassword());

            System.out.println(validateUser(user, password));
        }
    }

    private Boolean validateUser(String usernameInput, String passwordInput) {
        HashMap <String, String> userMap = new HashMap <>() {{
            put("mauro", "283578237958723895");
            put("juanjose", "289323");
        }};

        final Boolean[] isValid = { false };

        userMap.forEach((user, password) -> {
            if (usernameInput.equals(user) && passwordInput.equals(password))
                isValid[0] = true;
        });

        return isValid[0];
    }
}
