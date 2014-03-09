package marco.runner;

import marco.interpreter.MarcoInterpreter;
import marco.lang.MarcoProgram;
import marco.lang.exceptions.MarcoException;
import marco.parser.Parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Runner {
    private MarcoInterpreter interpreter = new MarcoInterpreter();

    public void run(String fileName) {
        Parser parser = Parser.instance();
        MarcoProgram program;

        try {
            program = parser.parse(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            throw new MarcoException("File not found: " + fileName);
        }

        interpreter.eval(program);
    }
}
