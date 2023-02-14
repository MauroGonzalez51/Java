package Code.InterfazGrafica;

import javax.swing.*;

public class App extends JFrame {
    private JLabel label;

    public App() {
        setLayout(null);
        label = new JLabel("Buenos dias ...");
        label.setBounds(10, 20, 200, 300);
        add(label);
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.setBounds(0, 0, 400, 300);
        app.setVisible(true);
        app.setLocationRelativeTo(null);
    }
}
