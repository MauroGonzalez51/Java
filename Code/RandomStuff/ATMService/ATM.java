package Code.RandomStuff.ATMService;

import java.io.IOException;
import java.nio.file.Path;

public interface ATM {
    // * Each class that 'implements' the Interface will have their own implementation of the methods
    // * So, you don't have to override the Methods (Since they aren't being inherited)
    public abstract Boolean createUserInstance(final Path folderPath) throws IOException;
    public abstract void checkAdminStatus() throws IOException;
}
