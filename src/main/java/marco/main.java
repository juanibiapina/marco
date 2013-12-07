package marco;

import marco.repl.Repl;
import marco.runner.Runner;

public class main {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            Repl repl = new Repl();
            repl.start();
            return;
        }

        if (args.length == 1) {
            String fileName = args[0];
            Runner runner = new Runner();
            runner.run(fileName);
            return;
        }

        throw new RuntimeException("Wrong number of arguments");
    }
}
