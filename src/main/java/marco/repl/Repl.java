package marco.repl;

import marco.interpreter.MarcoInterpreter;
import marco.lang.MarcoObject;
import marco.lang.exceptions.MarcoException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Repl {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private MarcoInterpreter interpreter = new MarcoInterpreter();

    public void start() throws IOException {
        printGreeting();

        while (true) {
            printShell();
            String line = readLine();
            try {
                MarcoObject result = interpreter.runLine(line);
                printResult(result);
            } catch (MarcoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printShell() {
        System.out.print(":) ");
    }

    private void printGreeting() {
        System.out.println("Marco REPL");
    }

    private void printResult(MarcoObject result) {
        System.out.println(result);
    }

    private String readLine() throws IOException {
        return reader.readLine();
    }
}
