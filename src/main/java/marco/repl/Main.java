package marco.repl;

import marco.MarcoRuntime;

public class Main {
    public static void main(String[] args) throws Exception {
        MarcoRuntime runtime = new MarcoRuntime();

        Repl repl = new Repl(runtime);
        repl.start();
    }
}
