public class Gato extends Felino {
    public Gato(String sonidos, String alimentos, String habitat, String nombreCientifico) {
        this.sonidos = sonidos;
        this.alimentos = alimentos;
        this.habitat = habitat;
        this.nombreCientifico = nombreCientifico;
    }

    public Gato() {
        this("", "", "", "");
    }
    
    // ! ---------- Getters ----------
    public String getSonidos() { return "Maullido";}
    public String getAlimentos() { return "Ratones"; }
    public String getHabitat() { return "Domestico"; }
    public String getNombreCientifico() { return "Felis silvestris catus"; }

    // ! ---------- Setters ----------
    public void setSonidos(String val) { this.sonidos = val; }
    public void setAlimentos(String val) { this.alimentos = val; }
    public void setHabitat(String val) { this.habitat = val; }
    public void setNombreCientifico(String val) { this.nombreCientifico = val; }
}
