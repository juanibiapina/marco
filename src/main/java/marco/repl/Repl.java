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
                MarcoObject chain = runtime.parse(line).sendMessage(runtime.object, "pop_first");
                MarcoObject result = runtime.interpreter.evalLine(runtime.object, chain);
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
        result.sendMessage(runtime.object, "puts");
    }

    private String readLine() throws IOException {
        return reader.readLine() + "\n";
    }
}
