package marco.runner;

import marco.lang.exceptions.MarcoException;
import marco.runtime.MarcoRuntime;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Runner {
    private MarcoRuntime runtime = new MarcoRuntime();

    public void run(String fileName) {
        try {
            runtime.run(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            throw new MarcoException("File not found: " + fileName);
        }
    }
}
