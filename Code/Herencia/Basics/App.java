package Code.Herencia.Basics;

public class App {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.printSomething();

        Parent child = new Child();
        child.printSomething();
        child.showSomething();
    }
}
