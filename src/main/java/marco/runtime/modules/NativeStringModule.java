package marco.runtime.modules;

import marco.lang.MarcoFunction;
import marco.lang.MarcoModule;
import marco.lang.functions.strings.from;
import marco.lang.functions.strings.concat;
import marco.runtime.Environment;

import java.util.Arrays;

public class NativeStringModule extends MarcoModule {
    public NativeStringModule(Environment environment) {
        export("concat", new MarcoFunction(environment, Arrays.asList("values"), new concat()));
        export("from", new MarcoFunction(environment, Arrays.asList("value"), new from()));
    }
}
