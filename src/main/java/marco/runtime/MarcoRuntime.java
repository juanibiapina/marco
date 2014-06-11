package marco.runtime;

import marco.internal.Environment;
import marco.lang.MarcoObject;
import marco.parser.Parser;

import java.io.InputStream;

public class MarcoRuntime {
    private Environment environment = Environment.initial();
    private Parser parser = Parser.instance();

    public MarcoObject run(InputStream inputStream) {
        return parser.parse(inputStream).eval(environment);
    }

    public MarcoObject run(String line) {
        return parser.parse(line).eval(environment);
    }
}
