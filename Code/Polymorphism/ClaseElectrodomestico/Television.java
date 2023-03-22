package Code.Polymorphism.ClaseElectrodomestico;

public class Television extends Electrodomestico {
    private Double resolucion;
    private Boolean sintonizadorTDT;

    public Television() {
        super();
        this.resolucion = 20.0;
        this.sintonizadorTDT = false;
        // super.precioFinal();
    }

    public Television(Double precioBase, String color, String consumoEnergetico, Double peso, Double resolucion, Boolean sintonizadorTDT) {
        super(precioBase, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
        // super.precioFinal();
    }

    public Double getResolucion() { return this.resolucion; }
    public Boolean getSintonizadorTDT() { return this.sintonizadorTDT; }

    @Override
    protected void precioFinal() {
        // ! When calling the SuperClass methods, Child atributes
        super.precioFinal();
        // System.out.println(this.sintonizadorTDT);

        // if (this.resolucion > 40) { addPrecioFinal(getPrecioFinal() * 0.3); }
        
        // if (this.sintonizadorTDT) { addPrecioFinal(50.0); }
    }
}
