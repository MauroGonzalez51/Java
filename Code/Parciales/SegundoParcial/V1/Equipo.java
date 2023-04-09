package Code.Parciales.SegundoParcial.V1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Equipo {

    // ! ClassAttributes
    private String nombreEquipo;
    private Double tiemposDeCarreraPromedio;

    private ArrayList <Ciclistas> ciclistas = new ArrayList <>();

    // * DefaultConstructor > UserInput to take the 'nombreEquipo' field
    public Equipo() {
        Scanner scannerIn = null;

        try {
            scannerIn = new Scanner(System.in);
            do {
                System.out.format("Ingrese el nombre del equipo: ");
                this.nombreEquipo = (scannerIn.hasNext()) ? scannerIn.next() : "";
            } while (this.nombreEquipo.isEmpty());
        } catch (Exception e) { e.printStackTrace(); }

        this.tiemposDeCarreraPromedio = 0.0;
    }

    // * Getters && Setters
    protected String getNombreEquipo() { return this.nombreEquipo; }
    protected Double tiemposDeCarreraPromedio() { return this.tiemposDeCarreraPromedio; }

    protected void setNombreEquipo(String val) { this.nombreEquipo = val; }
    protected void setTiemposDeCarreraPromedio(Double val) { this.tiemposDeCarreraPromedio = val; } 

    // * Method to calculate the averageRaceTime
    protected void averageRaceTime() {

        // * Iterates over all the 'Ciclista' stored in 'Ciclistas'
        this.ciclistas.forEach((ciclista) -> {
            this.tiemposDeCarreraPromedio += ciclista.getTiempoAcumuladoEnCarrera();
        });

        // * Finnaly divides it by the ciclistas.size() (Amount of people)
        this.tiemposDeCarreraPromedio /= this.ciclistas.size();
    }

    // ! Method to print all the Data stored
    protected void printTeam() {
        this.printlnInConsole(30);
        System.out.println("Datos del equipo");

        System.out.format("Nombre del equipo: %s%n", this.nombreEquipo);
        System.out.format("TIempo de carrera promedio: %f%n", this.tiemposDeCarreraPromedio);

        // * .forEach(() -> {}); to print all the info by each 'Ciclista'
        ciclistas.forEach((ciclista) -> {
            this.printlnInConsole(15);
            System.out.format("Ciclista [%d]%n", ciclistas.indexOf(ciclista) + 1);
            ciclista.printInfo();
        });
    }

    // * Printing more lines in console :D
    protected void printlnInConsole(Integer amountOfChar) {
        System.out.println();
        for (Integer i = 0; i < amountOfChar; i++) { System.out.format("-"); }
        System.out.println();
    }

    /*
     * This method can perform two different tasks depending on the @params 
     * 
     * 1 |-------------------------------------------------------------------------------------|>
     *
     * > Search by each type of 'Ciclista' type
     * So, in order to do that 'searchBySomebodyInTeam' must be False
     * And the else{} block won't be executed
     * 
     * 2 |-------------------------------------------------------------------------------------|>
     * 
     * > Search a 'Ciclista' by 'Name' && 'ID'
     * 'searchSomebodyInTeam' must be true here
     * 
     * > Asks the User for both values and iterates through the 'Ciclistas' to look for any
     * coincidence
     * 
     * If so, return an HashMap with the results
     */

    protected HashMap <Integer, Integer> searchByParam(String typeToSeach, Boolean searchSomebodyInTeam) {
        
        // ! [1]: Storing the Index of 'ciclista' in the max order list
        // ! [2]: Storing the actual ID to be displayed
        HashMap <Integer, Integer> hashMapToReturn = new HashMap <>();

        if (!searchSomebodyInTeam) {
            this.ciclistas.forEach((ciclista) -> {
                if (ciclista.getClass().getSimpleName().toString().equals(typeToSeach)) {
                    hashMapToReturn.put(this.ciclistas.indexOf(ciclista), ciclista.getID());
                }
            });
        } else {
            Scanner scannerIn = null;
            String[] arrayInfo = new String[2];

            System.out.println("Ingrese los datos para proceder con la busqueda ...");

            // * [N] [Index] must be removed in order to prevent a fail cuz of BadUserInput

            /*
             * The way it stores the info, changes the 'N' value 
             * [0] [Index] : Storing the 'ID'
             * [1] [Index] : Storing the 'Nombre'
             * 
             */

            try {
                scannerIn = new Scanner(System.in);

                do {
                    System.out.format("Ingrese el [ID]: ");
                    arrayInfo[0] = scannerIn.nextLine();
                } while (arrayInfo[0].isEmpty());
                
                do {
                    System.out.format("Ingrese el [Nombre]: ");
                    arrayInfo[1] = scannerIn.nextLine();
                } while (arrayInfo[1].isEmpty());

            } catch (Exception e) {}

            // * Iteration to loof for coincidences

            /*
             * The .forEach() method can be breaked cuz isn't as easy as expected :>
             * So, it will reuturn all the coincidences :>
             * 
             */

            this.ciclistas.forEach((ciclista) -> {
                if ((ciclista.getID().toString().equals(arrayInfo[0])) && (ciclista.getNombreCiclista().equals(arrayInfo[1]))) {
                    hashMapToReturn.put(this.ciclistas.indexOf(ciclista), ciclista.getID());
                }
            });
        }

        return hashMapToReturn;
    }

    /*
     * Method that is gonna be called to WriteTheInfo in console 
     * Works the same as 'searchByParam()'
     * 
     */

    protected void printResultsByType(Boolean searchSomebodyInTeam) {
    // * Flag ArrayList just to send the names to the method '.searchByParam()'
        ArrayList <String> derivatedClassNames = new ArrayList <>(Arrays.asList("Escalador", "Velocista",
            "Contrarelojista"
        ));

        if (!searchSomebodyInTeam) {
            derivatedClassNames.forEach((className) -> {
                this.printlnInConsole(25);
                System.out.format("[%s]%n", className);
                this.searchByParam(className, false).forEach((indexOfCiclista, ID) -> {
                    System.out.format("> [ ID ]: %s  | [ NOMBRE ]: %s%n", 
                        ID, this.ciclistas.get(indexOfCiclista).getNombreCiclista());
                });
            });
        } else { 
            this.printlnInConsole(25);
            
            HashMap <Integer, Integer> searchResults = this.searchByParam(null, true);
            
            if (searchResults.size() > 0) {
                searchResults.forEach((indexOfCiclista, ID) -> {
                    System.out.format("> [ ID ]: %s  | [ Nombre ]: %s%n",
                        ID, this.ciclistas.get(indexOfCiclista).getNombreCiclista());
                });
            } else 
                System.out.println("No se encontraron coindicencias");

        }
    }

    /*
     * Method that takes a UserInput an adds a Instance of Ciclista in the ArrayList 
     * By Instace refers to a DerivatedClassObject
     * 
     */

    protected void createInstanceOfCiclista() {
        Scanner scannerIn = null;

        this.printlnInConsole(30);

        ArrayList <String> typesOfCiclista = new ArrayList <>(Arrays.asList(
            "1) Escalador",
            "2) Velocista",
            "3) Contrarelojista"
        ));

        // * Shows the options ...
        typesOfCiclista.forEach((typeOfCiclista) -> {
            System.out.format("%s%n", typeOfCiclista);
        });

        final String[] optionIngresed = { null };

        try {
            scannerIn = new Scanner(System.in);
            do {
                System.out.format("Ingrese una opcion: ");
                optionIngresed[0] = (scannerIn.hasNext()) ? scannerIn.next() : "";
            } while (optionIngresed[0].isEmpty());
        } catch (Exception e) { e.printStackTrace(); }

        // * Evaluate each case depending on the input
        switch (optionIngresed[0]) {
            case "1": {
                this.ciclistas.add(new Escalador());
                break;
            }

            case "2": {
                this.ciclistas.add(new Velocista());
                break;
            }

            case "3": {
                this.ciclistas.add(new Contrarelojista());
                break;
            }

            default: System.out.format("[ OPTION NOT SUPPORTED ]%n");
        }
    }
}
