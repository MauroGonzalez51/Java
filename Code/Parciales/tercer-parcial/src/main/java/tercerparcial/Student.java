package tercerparcial;

public class Student {
    private Integer ID;
    private String name;
    private String gender;
    private Double gradesInformatica;
    private Double gradesFisica;
    private Double gradesQuimica;

    public Student(String ID, String name, String gender,String gradesInformatica, String gradesFisica, 
            String gradesQuimica) {
        this.ID = Integer.parseInt(ID);
        
        this.name = name;
        this.gender = gender;

        this.gradesInformatica = Double.parseDouble(gradesInformatica);
        this.gradesFisica = Double.parseDouble(gradesFisica);
        this.gradesQuimica = Double.parseDouble(gradesQuimica);
    }

    

    public Student(Integer iD, String name, String gender, Double gradesInformatica, Double gradesFisica,
            Double gradesQuimica) {
        this.ID = iD;

        this.name = name;
        this.gender = gender;
        
        this.gradesInformatica = gradesInformatica;
        this.gradesFisica = gradesFisica;
        this.gradesQuimica = gradesQuimica;
    }



    public Integer getID() { return this.ID; }

    public void setID(Integer iD) { this.ID = iD; }

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    public String getGender() { return this.gender; }

    public void setGender(String gender) { this.gender = gender; }

    public Double getGradesInformatica() { return this.gradesInformatica; }

    public void setGradesInformatica(Double gradesInformatica) { this.gradesInformatica = gradesInformatica; }

    public Double getGradesFisica() { return this.gradesFisica; }

    public void setGradesFisica(Double gradesFisica) { this.gradesFisica = gradesFisica; }

    public Double getGradesQuimica() { return this.gradesQuimica; }

    public void setGradesQuimica(Double gradesQuimica) { this.gradesQuimica = gradesQuimica; }

}
