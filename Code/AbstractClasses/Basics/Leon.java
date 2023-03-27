public class Leon extends Felino {
    public Leon(String sonidos, String alimentos, String habitat, String nombreCientifico) {
        this.sonidos = sonidos;
        this.alimentos = alimentos;
        this.habitat = habitat;
        this.nombreCientifico = nombreCientifico;
    }

    public Leon() {
        this("", "", "", "");
    }

    // ! ---------- Getters ----------
    public String getSonidos() { return "Rugido";}
    public String getAlimentos() { return "Carnivoro"; }
    public String getHabitat() { return "Pradera"; }
    public String getNombreCientifico() { return "Pantera leo"; }

    // ! ---------- Setters ----------
    public void setSonidos(String val) { this.sonidos = val; }
    public void setAlimentos(String val) { this.alimentos = val; }
    public void setHabitat(String val) { this.habitat = val; }
    public void setNombreCientifico(String val) { this.nombreCientifico = val; }
}
