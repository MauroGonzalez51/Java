package Code.Polymorphism.ClaseElectrodomestico;

import java.util.List;

public class Electrodomestico {

    // * ClassAttributes => All private
    private Double precioBase;
    private String color;
    private String consumoEnergetico;
    private Double peso;

    private Double precioFinal = 0.0;

    // ! ExtraAttributes : Work as'helpers' for the methods => So, declaring globaly means that each method will no longer need a copy of them
    private List <String> validColors = List.of("Blanco", "Negro", "Rojo", "Azul", "Gris");
    private List <String> validEnergy = List.of("A", "B", "C", "D", "E", "F");
    private List <Double> energyAddingCost = List.of(100.0, 80.0, 60.0, 50.0, 30.0, 10.0);

    // ! Dafault Constructor
    // * (@params any)
    public Electrodomestico() {
        this.precioBase = 100.0;
        this.color = "Blanco";
        this.consumoEnergetico = "F";
        this.peso = 5.0;

        // * ---------- Calling the Methods --------|>
        this.comprobarConsumoEnergetico();
        this.comprobarColor();
        // this.precioFinal();
    }
    
    // ! Constructor
    // * Prototype (@params Double, @params Double)
    public Electrodomestico(Double precioBase, Double peso) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.color = "Blanco";
        this.consumoEnergetico = "F";
        
        // * ---------- Calling the Methods --------|>
        this.comprobarConsumoEnergetico();
        this.comprobarColor();
        // this.precioFinal();
    }
    
    // ! Constructor
    // * Prototype (@params Double, @params String, @params String, @params Double)
    public Electrodomestico(Double precioBase, String color, String consumoEnergetico, Double peso) {
        this.precioBase = precioBase;
        this.color = color;
        this.consumoEnergetico = consumoEnergetico;
        this.peso = peso;
        
        // * ---------- Calling the Methods --------|>
        this.comprobarConsumoEnergetico();
        this.comprobarColor();
        // this.precioFinal();
    }

    private void comprobarConsumoEnergetico() {
        // * Flag variable
        Boolean isValid = false;
        for (var validOption : this.validEnergy) {
            // ! If the given value of 'consumoEnergetico' matches any of the ValidOptions, then isValid = true
            if (this.consumoEnergetico.equalsIgnoreCase(validOption)) {
                isValid = !isValid;
                // * This break is the one that makes this block work, because it 'breaks' the Loop as it where in a switch-case 
                // *    So, it prevents validating the rest of the options
                break;
            }
        } 

        // * After the loop ends it checks for the isValid value, if it's false => declare 'consumoEnergetico' as default
        if (!isValid) this.consumoEnergetico = "F";
    }

    private void comprobarColor() {
        // ! Same process as 'comprobarConsumoEnergetico()'
        Boolean isValid = false;
        for (var validOption : this.validColors) {
            if (this.color.equalsIgnoreCase(validOption)) {
                isValid = !isValid;
                break;
            }
        }

        if (!isValid) this.color = "Blanco";
    }

    protected void precioFinal() {
        // * This line adds to 'precioFinal' the 'precioBase' based on the index
        // * Each 'consumoEnergetico' has an associated index with 'energyAddingCost'
        // *        1) Using .indexOf() to get the index of an element <A>
        // *        2) Sending that index to .get() => So, getting the element that is stored in 'energyAddingCost' of index <A>

        this.precioFinal += this.precioBase + (energyAddingCost.get(validEnergy.indexOf(this.consumoEnergetico)));

        // ! Two list associated with each other 
        List <Double> weightBreakpoint = List.of(20.0, 50.0, 80.0);
        List <Integer> weightAddingCost = List.of(10, 50 , 80, 100);

        for (Integer i = 0; i < weightBreakpoint.size(); i++) {
            // * Instead of using a if-else block, it's a loop that goes throught each value and compare in pairs

            // * First, validating that 'i' doesn't have the index of the last element
            if (i != (weightBreakpoint.size() - 1)) {

                // * Here it validates if 'this.peso' if lower than each weightBrakpoint element
                if (this.peso < weightBreakpoint.get(i)) {
                    // * if it's true, it adds his value to 'precioFinal'
                    this.precioFinal += weightAddingCost.get(i);
                    break;
                }
            } else this.precioFinal += weightAddingCost.get(i); /* In case of being the last index */
        }
    }

    // ! ---------- Getters and Setters -----------------------------------------------------------------------------------------|>

    public Double getPrecioBase() { return this.precioBase; }
    public String getColor() { return this.color; }
    public String getConsumoEnergetico() { return this.consumoEnergetico; }
    public Double getPeso() { return this.peso; }
    public Double getPrecioFinal() { return this.precioFinal; }

    public void setPrecioBase(Double precioBase) { this.precioBase = precioBase; }
    public void setColor(String color) { this.color = color; }
    public void setConsumoEnergetico(String consumoEnergetico) { this.consumoEnergetico = consumoEnergetico; }
    public void setPeso(Double peso) { this.peso = peso; }
    public void addPrecioFinal(Double val) { this.precioFinal += val; }
}
