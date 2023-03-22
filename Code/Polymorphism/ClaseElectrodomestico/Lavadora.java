package Code.Polymorphism.ClaseElectrodomestico;

public class Lavadora extends Electrodomestico {
    private Double carga;

    public Lavadora() {
        super();
        this.carga = 5.0;
    }

    public Lavadora(Double precioBase, String color, String consumoEnergetico, Double peso, Double carga) {
        super(precioBase, color, consumoEnergetico, peso);
        this.carga = carga;       
    }

    public Double getCarga() { return this.carga; }

    @Override 
    protected void precioFinal() {
        if (this.carga > 30.0) addPrecioFinal(50.0);
    }
}
