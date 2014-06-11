package marco.runtime;

import marco.internal.Environment;
import marco.internal.TopLevelEnvironment;
import marco.lang.MarcoModule;
import marco.lang.MarcoObject;
import marco.parser.Parser;

import java.io.InputStream;

public class MarcoRuntime {
    private Environment environment = new TopLevelEnvironment();
    private Parser parser = Parser.instance();

    public MarcoObject run(InputStream inputStream) {
        MarcoModule program = parser.parse(inputStream);
        MarcoObject result = null;
        for (MarcoObject form : program.getForms()) {
            environment = environment.spawn();
            result = form.eval(environment);
        }
        return result;
    }

    public MarcoObject run(String line) {
        MarcoModule program = parser.parse(line);
        MarcoObject result = null;
        for (MarcoObject form : program.getForms()) {
            environment = environment.spawn();
            result = form.eval(environment);
        }
        return result;
    }
}
