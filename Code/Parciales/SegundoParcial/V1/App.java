package Code.Parciales.SegundoParcial.V1;

public class App {
    public static void main(String[] args) {
        Equipo equipoCiclistas = new Equipo();
        equipoCiclistas.ciclistas.add(new Contrarelojista());
        equipoCiclistas.ciclistas.get(0).printInfo();
    }
}