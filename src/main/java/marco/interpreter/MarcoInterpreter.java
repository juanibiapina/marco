package marco.interpreter;

import marco.internal.Environment;
import marco.lang.MarcoObject;
import marco.parser.Parser;

public class MarcoInterpreter {
    private Environment environment = Environment.initial();

    public MarcoObject runLine(String line) {
        return eval(Parser.instance().parse(line));
    }

    public MarcoObject eval(MarcoObject object) {
        return object.eval(environment);
    }
}
