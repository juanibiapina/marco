package marco.repl;

import marco.MarcoException;
import marco.lang.MarcoObject;
import marco.lang.MarcoRuntime;
import marco.parser.MarcoProgram;

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
                MarcoProgram program = runtime.parse(line);
                MarcoObject result = program.eval(runtime.object);
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
        result.slot("puts");
    }

    private String readLine() throws IOException {
        return reader.readLine();
    }
}
