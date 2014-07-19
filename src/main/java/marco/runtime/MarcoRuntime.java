package marco.runtime;

import marco.internal.*;
import marco.lang.MarcoModule;
import marco.lang.MarcoObject;
import marco.lang.MarcoProgram;
import marco.lang.exceptions.MarcoException;
import marco.parser.Parser;
import marco.runtime.modules.NativeIOModule;
import marco.runtime.modules.NativeIntegerModule;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MarcoRuntime {
    private final TopLevelEnvironment topLevelEnvironment;
    private Environment environment;
    private Parser parser;
    private Stack stack;
    private Map<String, MarcoModule> nativeModules = new HashMap<>();

    public MarcoRuntime() {
        parser = Parser.instance();
        stack = new Stack();
        topLevelEnvironment = new TopLevelEnvironment(this);
        environment = topLevelEnvironment;

        Environment nativeModuleEnvironment = topLevelEnvironment.spawn();
        NativeIOModule nativeIOModule = new NativeIOModule(nativeModuleEnvironment);
        nativeModuleEnvironment.setModule(nativeIOModule);
        nativeModules.put("io", nativeIOModule);

        Environment nativeModuleEnvironment2 = topLevelEnvironment.spawn();
        MarcoModule nativeIntegerModule = new NativeIntegerModule(nativeModuleEnvironment2);
        nativeModuleEnvironment.setModule(nativeIntegerModule);
        nativeModules.put("integer", nativeIntegerModule);
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

    public MarcoModule requireModule(String name) {
        String fileName = name + ".mrc";
        InputStream input = this.getClass().getClassLoader().getResourceAsStream(fileName);

        if (input == null) {
            throw new MarcoException("Module not found in classpath: " + name);
        }

        MarcoProgram program = parser.parse(fileName, input);
        return program.asBlock().module(this);
    }

    public MarcoModule requireNativeModule(String name) {
        if (nativeModules.containsKey(name)) {
            return nativeModules.get(name);
        } else {
            throw new MarcoException("Native module not found in classpath: " + name);
        }
    }

}
