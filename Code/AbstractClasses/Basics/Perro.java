public class Perro extends Canino {
    public Perro(String sonidos, String alimentos, String habitat, String nombreCientifico) {
        this.sonidos = sonidos;
        this.alimentos = alimentos;
        this.habitat = habitat;
        this.nombreCientifico = nombreCientifico;
    }

    public Perro() {
        this("", "", "", "");
    }

    // ! ---------- Getters ----------
    public String getSonidos() { return "Ladrido";}
    public String getAlimentos() { return "Carnivoro"; }
    public String getHabitat() { return "Domestico"; }
    public String getNombreCientifico() { return "Canis lupus familiaris"; }

    // ! ---------- Setters ----------
    public void setSonidos(String val) { this.sonidos = val; }
    public void setAlimentos(String val) { this.alimentos = val; }
    public void setHabitat(String val) { this.habitat = val; }
    public void setNombreCientifico(String val) { this.nombreCientifico = val; }
}