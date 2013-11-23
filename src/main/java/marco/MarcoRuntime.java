package marco;

import marco.internal.Environment;
import marco.lang.MarcoObject;
import marco.lang.MarcoProgram;
import marco.parser.Parser;

public class MarcoRuntime {

    private Parser parser = new Parser();

    private Environment environment = new Environment();

    public MarcoProgram parse(String code) {
        return parser.parse(code);
    }

    public MarcoObject eval(String code) {
        MarcoProgram program = parser.parse(code);
        return program.eval(environment);
    }

    public Environment getEnvironment() {
        return environment;
    }
}
