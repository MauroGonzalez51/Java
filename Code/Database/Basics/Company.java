package Code.Database.Basics;

import java.io.IOException;
import java.util.Scanner;

public class Company {
    private String companyName;
    private String NIT;

    private Scanner scannerIn;

    // ! This constructor is called first by the super() method
    public Company(Integer flagCompany) throws IOException {

        this.scannerIn = new Scanner(System.in);

        try {
            do {
                System.out.format("[%d] Ingrese el nombre de la empresa: ", flagCompany + 1);
                this.companyName = (scannerIn.hasNext()) ? scannerIn.next() : "";
            } while (this.companyName.isEmpty());
            
            do {
                System.out.format("[%d] Ingrese el NIT de la empresa: ", flagCompany + 1);
                this.NIT = (scannerIn.hasNext()) ? scannerIn.next() : "";
            } while (this.NIT.isEmpty());
        } catch (Exception e) {}
    }
}
