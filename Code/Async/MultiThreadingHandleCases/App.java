package Code.Async.MultiThreadingHandleCases;

import junit.framework.Test;

public class App {
    public static void main(String[] args) {
        for (Integer i = 1; i < 3; i++) {
            TestClass test = new TestClass();
            Runnable runnable = test.createRunnable(i.toString());
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
