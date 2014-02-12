package marco.runner;

import marco.internal.Environment;
import marco.lang.MarcoProgram;
import marco.lang.exception.MarcoException;
import marco.parser.Parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Runner {
    private Environment environment = Environment.initial();

    public void run(String fileName) {
        Parser parser = Parser.instance();
        MarcoProgram program;

        try {
            program = parser.parse(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            throw new MarcoException("File not found: " + fileName);
        }

        program.eval(environment);
    }
}
