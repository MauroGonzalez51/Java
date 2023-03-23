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
        // ! When calling the SuperClass method, child atributes turns null
        // * So, in order to prevent that the SuperClass method is no longer called 
        // * In the SuperConstructor, instead is called here
        super.precioFinal();
        // System.out.println(this.carga);
        if (this.carga > 50) super.addPrecioFinal(50.0);
    }
}
