package Code.InterfazGrafica.TamañoVentanas;

public class Main {
    public static void main(String[] args) throws Exception {
        Window window = new Window();

        // ! Por defecto todas las ventanas con JFrame estan invisibles
        // * Con .setVisible(true) hacemos visible la ventana :D
        window.setVisible(true);
    }
}
