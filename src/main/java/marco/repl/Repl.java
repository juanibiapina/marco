package marco.repl;

import marco.MarcoException;
import marco.lang.MarcoObject;
import marco.lang.MarcoRuntime;

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
                MarcoObject program = runtime.parse(line);
                MarcoObject result = runtime.interpreter.eval(runtime.global, program);
                printResult(result);
            } catch (MarcoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printResult(MarcoObject result) {
        result.sendMessage("puts");
    }

    private void printShell() {
        System.out.print(":) ");
    }

    private void printGreeting() {
        System.out.println("Marco REPL");
    }

    private String readLine() throws IOException {
        return reader.readLine();
    }
}
