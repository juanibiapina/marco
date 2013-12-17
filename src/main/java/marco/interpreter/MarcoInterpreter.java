package marco.interpreter;

import marco.internal.Environment;
import marco.lang.MarcoObject;

public class MarcoInterpreter {
    private Environment environment = Environment.initial();

    public MarcoObject runLine(String line) {
        return environment.parse(line).eval(environment);
    }
}
