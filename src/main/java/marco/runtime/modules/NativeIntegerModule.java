package marco.runtime.modules;

import marco.internal.Environment;
import marco.lang.MarcoFunction;
import marco.lang.MarcoModule;
import marco.lang.functions.integer.parse;

import java.util.Arrays;

public class NativeIntegerModule extends MarcoModule {
    public NativeIntegerModule(Environment environment) {
        export("parse", new MarcoFunction(environment, Arrays.asList("value"), new parse()));
    }
}
