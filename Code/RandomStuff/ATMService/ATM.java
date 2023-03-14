package Code.RandomStuff.ATMService;

import java.io.IOException;
import java.nio.file.Path;

abstract class ATM {
    public abstract Boolean createUserInstance(final Path folderPath) throws IOException;
}
