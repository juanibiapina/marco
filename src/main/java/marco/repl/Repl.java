package marco.repl;

import marco.internal.Environment;
import marco.lang.MarcoObject;
import marco.lang.exception.MarcoException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Repl {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Environment environment = Environment.initial();

    public void start() throws IOException {
        printGreeting();

        while (true) {
            printShell();
            String line = readLine();
            try {
                MarcoObject result = environment.parse(line).eval(environment);
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
