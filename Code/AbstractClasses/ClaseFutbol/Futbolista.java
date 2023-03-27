package Code.AbstractClasses.ClaseFutbol;

public class Futbolista extends SeleccionFutbol {
    private Integer dorsal;
    private String demarcacion;

    public Futbolista(Integer ID, String nombre, String apellidos, Integer edad, Integer dorsal, String demarcacion) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.dorsal = dorsal;
        this.demarcacion = demarcacion;
    }

    public Futbolista() {
        this(null, null, null, null, null, null);
    }

    public Integer getID() { return this.ID; }
    public String getNombre() { return this.nombre; }
    public String getApellidos() { return this.apellidos; }
    public Integer getEdad() { return this.edad; }
    public Integer getDorsal() { return this.dorsal; }
    public String getDemarcacion() { return this.demarcacion; }

    public void viajar() { System.out.format("Fubotlista viajando :)%n"); }
    public void concentrarse() { System.out.format("*tira a porteria* *lo falla*%n"); }
    public void entrenamiento() { System.out.format("*correr*%n"); }
    public void partidoFutbol() { System.out.format("*Jugar el partido*%n"); }
    public void entrevista() { System.out.format("*ser entrevistado*%n");}
}
