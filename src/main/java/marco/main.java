package marco;

import marco.repl.Repl;

public class main {
    public static void main(String[] args) throws Exception {
        MarcoRuntime runtime = new MarcoRuntime();

        Repl repl = new Repl(runtime);
        repl.start();
    }
}
