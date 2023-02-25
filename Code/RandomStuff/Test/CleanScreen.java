package Code.RandomStuff.Test;

public class CleanScreen {
    public static void main(String[] args) {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            /*No hacer nada*/
        }
           /*Introduce tu código desde aquí*/
        
        System.out.format("Do something");
    }
}
