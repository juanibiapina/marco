package marco.repl;

import marco.lang.exception.MarcoException;
import marco.lang.MarcoObject;
import marco.MarcoRuntime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Repl {
    private MarcoRuntime runtime;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Repl(MarcoRuntime runtime) {
        this.runtime = runtime;
    }

    public void start() throws IOException {
        printGreeting();

        while (true) {
            printShell();
            String line = readLine();
            try {
                MarcoObject result = runtime.eval(line);
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
