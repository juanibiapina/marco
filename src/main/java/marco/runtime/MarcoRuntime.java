package marco.runtime;

import marco.internal.*;
import marco.lang.MarcoModule;
import marco.lang.MarcoProgram;
import marco.lang.MarcoObject;
import marco.parser.Parser;

import java.io.InputStream;

public class MarcoRuntime {
    private final TopLevelEnvironment topLevelEnvironment;
    private Environment environment;
    private Parser parser;
    private Stack stack;

    public MarcoRuntime() {
        parser = Parser.instance();
        stack = new Stack();
        topLevelEnvironment = new TopLevelEnvironment(this);
        environment = topLevelEnvironment;
    }

    public MarcoObject run(String fileName, InputStream inputStream) {
        MarcoProgram program = parser.parse(fileName, inputStream);
        MarcoObject result = null;
        for (MarcoObject form : program.getForms()) {
            environment = environment.spawn();
            result = form.eval(environment);
        }
        return result;
    }

    public MarcoObject run(String line) {
        MarcoProgram program = parser.parse(line);
        MarcoObject result = null;
        for (MarcoObject form : program.getForms()) {
            environment = environment.spawn();
            result = form.eval(environment);
        }
        return result;
    }

    public MarcoObject stack(Frame frame) {
        return stack.push(frame);
    }

    public StackTrace buildStackTrace() {
        return new StackTrace(stack);
    }

    public Environment createModuleEnvironment() {
        Environment moduleEnvironment = topLevelEnvironment.spawn();
        moduleEnvironment.setModule(new MarcoModule());
        return moduleEnvironment;
    }
}
