package Code.ModificadorAcceso.ClaseElectrodomestico;

public class Television extends Electrodomestico {
    private Double resolucion;
    private Boolean sintonizadorTDT;

    public Television() {
        super();
        this.resolucion = 20.0;
        this.sintonizadorTDT = false;
    }

    public Television(Double precioBase, String color, String consumoEnergetico, Double peso, Double resolucion, Boolean sintonizadorTDT) {
        super(precioBase, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public Double getResolucion() { return this.resolucion; }
    public Boolean getSintonizadorTDT() { return this.sintonizadorTDT; }
}
