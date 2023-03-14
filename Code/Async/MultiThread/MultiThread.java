package Code.Async.MultiThread;

// * By implementing the Runnable interface, you still can extend another class
public class MultiThread implements Runnable {
    // ! Then -> Override the thread Classes run method

    private Integer threadNumber;
    public MultiThread(Integer threadNumber) {
        this.threadNumber = threadNumber;
    }

    public void run() {
        // * Here is where it goes the code you want to run in multiple Threads
        for (Integer i = 1; i <= 5; i++) {
            System.out.format("%d from thread number %d%n", i, this.threadNumber);
            
            try {
                // * @params (Integer milliseconds)
                Thread.sleep(1000);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }

    }
}
