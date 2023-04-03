package Code.Parciales.SegundoParcial.V1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Equipo {
    private String nombreEquipo;
    private Double tiemposDeCarreraPromedio;

    private ArrayList <Ciclistas> ciclistas = new ArrayList <>();

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

    protected String getNombreEquipo() { return this.nombreEquipo; }
    protected Double tiemposDeCarreraPromedio() { return this.tiemposDeCarreraPromedio; }

    protected void setNombreEquipo(String val) { this.nombreEquipo = val; }
    protected void setTiemposDeCarreraPromedio(Double val) { this.tiemposDeCarreraPromedio = val; } 

    protected void averageRaceTime() {
        this.ciclistas.forEach((ciclista) -> {
            this.tiemposDeCarreraPromedio += ciclista.getTiempoAcumuladoEnCarrera();
        });

        this.tiemposDeCarreraPromedio /= this.ciclistas.size();
    }

    protected void printTeam() {
        this.printlnInConsole(30);
        System.out.println("Datos del equipo");

        System.out.format("Nombre del equipo: %s%n", this.nombreEquipo);
        System.out.format("TIempo de carrera promedio: %f%n", this.tiemposDeCarreraPromedio);

        ciclistas.forEach((ciclista) -> {
            this.printlnInConsole(15);
            System.out.format("Ciclista [%d]%n", ciclistas.indexOf(ciclista) + 1);
            ciclista.printInfo();
        });
    }

    protected void printlnInConsole(Integer amountOfChar) {
        System.out.println();
        for (Integer i = 0; i < amountOfChar; i++) { System.out.format("-"); }
        System.out.println();
    }

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
            final ArrayList <String> arrayInfo = new ArrayList <>(Arrays.asList("", ""));

            System.out.println("Ingrese los datos para proceder con la busqueda ...");

            try {
                scannerIn = new Scanner(System.in);
                do {
                    arrayInfo.remove(0);
                    System.out.format("Ingrese el [ID]: ");
                    arrayInfo.add((scannerIn.hasNext()) ? scannerIn.next() : "");
                } while (arrayInfo.get(0).isEmpty());
            } catch (Exception e) { e.printStackTrace(); }

            try {
                scannerIn = new Scanner(System.in);
                do {
                    arrayInfo.remove(1);
                    System.out.format("Ingrese el [Nombre]: ");
                    arrayInfo.add((scannerIn.hasNext()) ? scannerIn.next() : "");
                } while (arrayInfo.get(1).isEmpty());
            } catch (Exception e) { e.printStackTrace(); }

            this.ciclistas.forEach((ciclista) -> {
                if ((ciclista.getID().toString().equals(arrayInfo.get(0))) && (ciclista.getNombreCiclista().equals(arrayInfo.get(1)))) {
                    hashMapToReturn.put(this.ciclistas.indexOf(ciclista), ciclista.getID());
                }
            });
        }

        return hashMapToReturn;
    }

    protected void printResultsByType(Boolean searchSomebodyInTeam) {
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
            this.searchByParam(null, true).forEach((indexOfCiclista, ID) -> {
                System.out.format("> [ ID ]: %s  | [ Nombre ]: %s%n",
                    ID, this.ciclistas.get(indexOfCiclista).getNombreCiclista());
            });
        }
    }

    protected void createInstanceOfCiclista() {
        Scanner scannerIn = null;

        this.printlnInConsole(30);

        ArrayList <String> typesOfCiclista = new ArrayList <>(Arrays.asList(
            "1) Escalador",
            "2) Velocista",
            "3) Contrarelojista"
        ));

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
