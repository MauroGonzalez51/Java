package Code.Async.MultiThread;

public class MultiThreading {
    public static void main(String[] args) throws InterruptedException {
        // ! 1) Have a class that extends the Thread class

        // ! 2) Creating an object of that class
        for (Integer i = 0; i < 5; i++) {
            MultiThread myThing = new MultiThread(i);
            Thread thread = new Thread(myThing);
            thread.start();

            // * Method that waits for the thread to ends
            thread.join();

            // * Another method -> While running : true
            thread.isAlive();
        }
    

    }
}
