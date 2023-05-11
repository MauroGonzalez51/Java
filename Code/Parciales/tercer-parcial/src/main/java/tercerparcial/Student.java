package tercerparcial;

/*
 * SkeletonClass for all the Student(s)
 * 
 */

public class Student {
    /*
     * ClassAttibutes ----------------------------------------------------------------|>
     */

    private Integer ID;
    private String name;
    private String gender;
    private Double gradesInformatica;
    private Double gradesFisica;
    private Double gradesQuimica;

    /*
     * Constructor > Used when gathering the info from the database
     * 
     * When getting the info, it comes as String -> changeType
     * 
     * Integer.parseInt(new String())
     * Double.parseDouble(new String())
     */

    public Student(String ID, String name, String gender,String gradesInformatica, String gradesFisica, 
            String gradesQuimica) {
        this.ID = Integer.parseInt(ID);
        
        this.name = name;
        this.gender = gender;

        this.gradesInformatica = Double.parseDouble(gradesInformatica);
        this.gradesFisica = Double.parseDouble(gradesFisica);
        this.gradesQuimica = Double.parseDouble(gradesQuimica);
    }

    /*
     * Constructor > Used when creating a new Student from the GUI
     * 
     * No need to change the dataType
     */

    public Student(Integer iD, String name, String gender, Double gradesInformatica, Double gradesFisica,
            Double gradesQuimica) {
        this.ID = iD;

        this.name = name;
        this.gender = gender;
        
        this.gradesInformatica = gradesInformatica;
        this.gradesFisica = gradesFisica;
        this.gradesQuimica = gradesQuimica;
    }

    /*
     * Getters and Setters for the ClassAttributes -------------------------------------------------------------|>
     * 
     */

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
