package marco.runtime;

import marco.lang.MarcoBlock;
import marco.lang.MarcoModule;
import marco.lang.MarcoObject;
import marco.lang.exceptions.MarcoException;
import marco.parser.Parser;
import marco.runtime.modules.NativeIOModule;
import marco.runtime.modules.NativeIntegerModule;
import marco.runtime.modules.NativeStringModule;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MarcoRuntime {
    private final TopLevelEnvironment topLevelEnvironment;
    private Environment environment;
    private Parser parser;
    private Map<String, MarcoModule> nativeModules = new HashMap<>();

    private void includeModule(Environment environment, String moduleName) {
        MarcoModule module = loadModule(moduleName);
        module.include(environment);
    }

    public MarcoRuntime() {
        parser = Parser.instance();
        topLevelEnvironment = new TopLevelEnvironment(this);

        includeModule(topLevelEnvironment, "core");
        includeModule(topLevelEnvironment, "list");

        environment = topLevelEnvironment;

        Environment nativeModuleEnvironment = topLevelEnvironment.spawn();
        NativeIOModule nativeIOModule = new NativeIOModule(nativeModuleEnvironment);
        nativeModuleEnvironment.setModule(nativeIOModule);
        nativeModules.put("io", nativeIOModule);

        Environment nativeModuleEnvironment2 = topLevelEnvironment.spawn();
        MarcoModule nativeIntegerModule = new NativeIntegerModule(nativeModuleEnvironment2);
        nativeModuleEnvironment2.setModule(nativeIntegerModule);
        nativeModules.put("integer", nativeIntegerModule);

        Environment nativeModuleEnvironment3 = topLevelEnvironment.spawn();
        MarcoModule nativeStringModule = new NativeStringModule(nativeModuleEnvironment3);
        nativeModuleEnvironment3.setModule(nativeStringModule);
        nativeModules.put("string", nativeStringModule);
    }

    public void run(String fileName, InputStream inputStream) {
        environment = environment.spawn();

        MarcoBlock block = parser.parse(fileName, inputStream);

        invoke(block);
    }

    public MarcoObject run(String line) {
        environment = environment.spawn();

        MarcoBlock block = parser.parse(line);
        return invoke(block);
    }

    public MarcoObject invoke(MarcoBlock block) {
        block.__eval(environment);
        MarcoObject result = block.invokeLexically();
        while (result.isContinuation()) {
            result = result.resolve();
        }
        return result;
    }

    public MarcoObject invoke(MarcoBlock block, Environment closure, Environment dynamic) {
        MarcoObject result = block.invoke(closure, dynamic);
        while (result.isContinuation()) {
            result = result.resolve();
        }
        return result;
    }

    public Environment createModuleEnvironment() {
        Environment moduleEnvironment = topLevelEnvironment.spawn();
        moduleEnvironment.setModule(new MarcoModule());
        return moduleEnvironment;
    }

    public MarcoModule loadModule(String name) {
        String fileName = name + ".mrc";
        InputStream input = this.getClass().getClassLoader().getResourceAsStream(fileName);

        if (input == null) {
            throw new MarcoException("Module not found in classpath: " + name);
        }

        MarcoBlock block = parser.parse(fileName, input);
        return module(block);
    }

    public MarcoModule loadNativeModule(String name) {
        if (nativeModules.containsKey(name)) {
            return nativeModules.get(name);
        } else {
            throw new MarcoException("Native module not found in classpath: " + name);
        }
    }

    public MarcoObject eval(MarcoObject value, Environment dynamic) {
        MarcoObject result = value.__eval(dynamic);
        while (result.isContinuation()) {
            result = result.resolve();
        }
        return result;
    }

    public MarcoModule module(MarcoBlock block) {
        Environment moduleEnvironment = createModuleEnvironment();

        MarcoObject result = block.invokeWithEnvironment(moduleEnvironment);
        while (result.isContinuation()) {
            result = result.resolve();
        }

        return moduleEnvironment.getModule();
    }
}
