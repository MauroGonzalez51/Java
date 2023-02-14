package Code.InterfazGrafica;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Buttons extends JFrame {
    private static final String Color = null;

    private void colocarEtiquetas() {
        JLabel label = new JLabel();
        label.setText("Hello world!");
        label.setBounds(85, 10, 300, 80);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        // label.setForeground(Color.BLACK);
        label.setFont(new Font("JetBrains", 0, 40));
    }
}
