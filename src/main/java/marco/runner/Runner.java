package marco.runner;

import marco.lang.exceptions.MarcoException;
import marco.runtime.MarcoRuntime;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Runner {
    private MarcoRuntime runtime = new MarcoRuntime();
    private boolean debugMode = false;

    public void run(String fileName) {
        try {
            runtime.run(fileName, new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            throw new MarcoException("File not found: " + fileName);
        } catch (marco.lang.error.Error e) {
            if (debugMode) {
                throw e;
            } else {
                e.printMarcoStackTrace();
            }
        }
    }

    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }
}
