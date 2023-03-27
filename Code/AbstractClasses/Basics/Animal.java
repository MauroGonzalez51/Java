public abstract class Animal {
    
    // ! Class Methods 
    protected String sonidos;
    protected String alimentos;
    protected String habitat;
    protected String nombreCientifico;

    // ! ---------- Getters ----------
    public abstract String getSonidos();
    public abstract String getAlimentos();
    public abstract String getHabitat();
    public abstract String getNombreCientifico();

    // ! ---------- Setters ----------
    public abstract void setSonidos(String val);
    public abstract void setAlimentos(String val);
    public abstract void setHabitat(String val);
    public abstract void setNombreCientifico(String val);
}
