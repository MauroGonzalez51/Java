package Code.Polymorphism.Basics;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        /* 

        Student student = new Student("Mauro", "Gonzalez", 17, "82379523", "UTB");
        student.showCollegeName();

        System.out.println();

        Worker worker = new Worker("Juan", "Jimenez", 19, "897235836", 30);
        worker.showHoursOfWork();

        System.out.println();

        Freelancer freelancer = new Freelancer("Felipe", "Jose", 25, "89237236", "Developer");
        freelancer.showBusinessType();

        */

        ArrayList <Person> persons = new ArrayList<Person>();
        persons.add(new Student("Mauro", "Gonzalez", 17, "87239852", "UTB"));
        persons.add(new Worker("Juan", "Jose", 18, "8379525", 57));
        persons.add(new Freelancer("Samuel", "David", 22, "82973523", "Business"));

        // ! Same method but it will do different things depending on the Object (Class) that is calling it
        // * [ Override ] the SuperClass methods  so each DerivedClass as his own Implementation
        persons.forEach((person) -> {
            person.mostrarDeudas();
        });

        
    }
}
