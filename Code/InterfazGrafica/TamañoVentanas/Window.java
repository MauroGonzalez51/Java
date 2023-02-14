package Code.InterfazGrafica.TamañoVentanas;

import javax.swing.JFrame;

public class Window extends JFrame {

    // ! Constructor de la clase Window
    public Window() {
        // * Establece el ancho y largo de la ventana 
        // *        Prototype(WIDTH, HEIGHT)
        this.setSize(500, 500);

        // * Establece que se hace por defecto cuando se cierra la ventana
        // * En este caso, al momento de cerrar la ventana, termina la 
        // *    ejecucion del programa
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // * Establecer el titulo de la ventana 
        // *        Prototype(String)
        this.setTitle("Besto titulo");

        // * Cambiar la posicion inicial de la ventana
        // *        Prototype(x, y)
        // this.setLocation(100, 200);

        // * Combina el setLocation() y el setSize();
        // *         Prototype(X, Y, WIDTH, HEIGHT)
        // this.setBounds(100, 200, 500, 500);

        // * Situando la ventana en el centro de la pantalla
        this.setLocationRelativeTo(null);
    }
}
