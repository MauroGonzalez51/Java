package Code.AbstractClasses.ClaseFutbol;

public class Masajista extends SeleccionFutbol {
    private String titulacion;
    private Integer tiempoExperiencia;

    public Masajista(Integer ID, String nombre, String apellidos, Integer edad, String titulacion, Integer tiempoExperiencia) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.titulacion = titulacion;
        this.tiempoExperiencia = tiempoExperiencia;
    }

    public Masajista() {
        this(null, null, null, null, null, null);
    }

    public Integer getID() { return this.ID; }
    public String getNombre() { return this.nombre; }
    public String getApellidos() { return this.apellidos; }
    public Integer getEdad() { return this.edad; }
    public String getTitulacion() { return this.titulacion; }
    public Integer getTiempoExperiencia() { return this.tiempoExperiencia; }

    public void viajar() { System.out.format("Masajista viajando :)%n"); }
    public void concentrarse() { System.out.format("*curar las lesiones*%n"); }
    public void entrenamiento() { System.out.format("*quedarse observando*%n"); }
    public void partidoFutbol() { System.out.format("*esperar*%n"); }
    public void darMasaje() { System.out.format("*dar masaje*%n"); }
}
