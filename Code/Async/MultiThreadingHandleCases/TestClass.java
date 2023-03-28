package Code.Async.MultiThreadingHandleCases;

public class TestClass {
    public Runnable createRunnable(final String processToRun) {
        Runnable handleCase = new Runnable() {
            public void run() {
                switch(processToRun) {
                    case "1": {
                        countToANumber_1(1000000000);
                        break;
                    }
                    
                    case "2": {
                        countToANumber_2(1000000000);
                        break;
                    }

                    default: System.exit(1);
                }
            }
        };

        return handleCase;
    }

    
    // ! How to handle cases and Multi-thread them

    // public Runnable createRunnable(final String processToRun) {
    //     Runnable handleCase = new Runnable() {
    //         public void run() {
    //             switch(processToRun) {
    //                 case "1": { break; }

    //                 default: System.exit(1);
    //             }
    //         }
    //     };

    //     return handleCase;
    // }

    // * Now in order to create an object and run them

    // * TestClass test = new TestClass();
    // * Runnable runnable = test.createRunnable("{processToRun}");
    // * Thread thread = new Thread(runnable);
    // * thread.start();

    public void countToANumber_1(Integer numberToCount) {
        for (int i = 0; i < numberToCount; i++) {}
        
        System.out.format("Ending: %d [1]%n", numberToCount);
    }

    public void countToANumber_2(Integer numberToCount) {
        for (int i = 0; i < numberToCount; i++) {}
        
        System.out.format("Ending: %d [2]%n", numberToCount);
        
    }
}
