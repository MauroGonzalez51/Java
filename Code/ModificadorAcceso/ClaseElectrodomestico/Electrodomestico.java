package Code.ModificadorAcceso.ClaseElectrodomestico;

import java.util.List;

public class Electrodomestico {
    private Double precioBase;
    private String color;
    private String consumoEnergetico;
    private Double peso;

    private Double precioFinal = 0.0;

    // private String[] validColors = {"Blanco", "Negro", "Rojo", "Azul", "Gris"};
    // private String[] validEnergy = {"A", "B", "C", "D", "E", "F"};

    private List <String> validColors = List.of("Blanco", "Negro", "Rojo", "Azul", "Gris");
    private List <String> validEnergy = List.of("A", "B", "C", "D", "E", "F");
    private List <Double> energyAddingCost = List.of(100.0, 80.0, 60.0, 50.0, 30.0, 10.0);



    // ! Constructor por defecto
    // * (@params any)
    public Electrodomestico() {
        this.precioBase = 100.0;
        this.color = "Blanco";
        this.consumoEnergetico = "F";
        this.peso = 5.0;

        this.comprobarConsumoEnergetico();
        this.comprobarColor();
        this.precioFinal();
    }

    public Electrodomestico(Double precioBase, Double peso) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.color = "Blanco";
        this.consumoEnergetico = "F";

        this.comprobarConsumoEnergetico();
        this.comprobarColor();
        this.precioFinal();
    }

    public Electrodomestico(Double precioBase, String color, String consumoEnergetico, Double peso) {
        this.precioBase = precioBase;
        this.color = color;
        this.consumoEnergetico = consumoEnergetico;
        this.peso = peso;

        this.comprobarConsumoEnergetico();
        this.comprobarColor();
        this.precioFinal();
    }

    public void comprobarConsumoEnergetico() {
        Boolean isValid = false;
        for (var validOption : this.validEnergy) {
            if (this.consumoEnergetico.equalsIgnoreCase(validOption)) {
                isValid = !isValid;
                break;
            }
        } 

        if (!isValid) this.consumoEnergetico = "F";
    }

    public void comprobarColor() {
        Boolean isValid = false;
        for (var validOption : this.validColors) {
            if (this.color.equalsIgnoreCase(validOption)) {
                isValid = !isValid;
                break;
            }
        }

        if (!isValid) this.color = "Blanco";
    }

    public void precioFinal() {
        this.precioFinal += this.precioBase + (energyAddingCost.get(validEnergy.indexOf(this.consumoEnergetico)));

        List <Double> weightBreakpoint = List.of(20.0, 50.0, 80.0);
        List <Integer> weightAddingCost = List.of(10, 50 , 80, 100);

        for (Integer i = 0; i < weightBreakpoint.size(); i++) {
            if (i != (weightBreakpoint.size() - 1)) {
                if (this.peso < weightBreakpoint.get(i)) {
                    this.precioFinal += weightAddingCost.get(i);
                    break;
                }
            } else this.precioFinal += weightAddingCost.get(i);
        }
    }

    public Double getPrecioBase() { return this.precioBase; }
    public String getColor() { return color; }
    public String getConsumoEnergetico() { return this.consumoEnergetico; }
    public Double getPeso() { return this.peso; }
    public Double getPrecioFinal() { return this.precioFinal; }

    public void setPrecioBase(Double precioBase) { this.precioBase = precioBase; }
    public void setColor(String color) { this.color = color; }
    public void setConsumoEnergetico(String consumoEnergetico) { this.consumoEnergetico = consumoEnergetico; }
    public void setPeso(Double peso) { this.peso = peso; }
}
