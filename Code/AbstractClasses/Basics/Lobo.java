public class Lobo extends Canino {
    public Lobo(String sonidos, String alimentos, String habitat, String nombreCientifico) {
        this.sonidos = sonidos;
        this.alimentos = alimentos;
        this.habitat = habitat;
        this.nombreCientifico = nombreCientifico;
    }

    public Lobo() {
        this("", "", "", "");
    }

    // ! ---------- Getters ----------
    public String getSonidos() { return "Aullido";}
    public String getAlimentos() { return "Carnivoro"; }
    public String getHabitat() { return "Bosque"; }
    public String getNombreCientifico() { return "Canis lupus"; }

    // ! ---------- Setters ----------
    public void setSonidos(String val) { this.sonidos = val; }
    public void setAlimentos(String val) { this.alimentos = val; }
    public void setHabitat(String val) { this.habitat = val; }
    public void setNombreCientifico(String val) { this.nombreCientifico = val; }
}
