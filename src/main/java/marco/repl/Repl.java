package marco.repl;

import marco.lang.MarcoObject;
import marco.runtime.MarcoRuntime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Repl {
    private MarcoRuntime runtime = new MarcoRuntime();

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void start() throws IOException {
        printGreeting();

        while (true) {
            printShell();
            String line = readLine();
            try {
                MarcoObject result = runtime.run(line);
                printResult(result);
            } catch (marco.lang.error.Error e) {
                e.printMarcoStackTrace();
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
