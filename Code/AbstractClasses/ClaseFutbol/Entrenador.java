package Code.AbstractClasses.ClaseFutbol;

public class Entrenador extends SeleccionFutbol {
   private Integer idFederacion;

    public Entrenador(Integer ID, String nombre, String apellidos, Integer edad, Integer idFederacion) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.idFederacion = idFederacion;
    }

    public Entrenador() {
        this(null, null, null, null, null);
    }

    public Integer getID() { return this.ID; }
    public String getNombre() { return this.nombre; }
    public String getApellidos() { return this.apellidos; }
    public Integer getEdad() { return this.edad; }
    public Integer getIdFederacion() { return this.idFederacion; }


    public void viajar() { System.out.format("Entrenador viajando :)%n"); }
    public void concentrarse() { System.out.format("*pensar en nada*%n"); }
    public void entrenamiento() { System.out.format("*quedarse mirando*%n"); }
    public void partidoFutbol() { System.out.format("*pensar en nada* *quedarse mirando*%n"); }
    public void planificarEntrenamiento() { System.out.format("*observar* %n"); }
}
