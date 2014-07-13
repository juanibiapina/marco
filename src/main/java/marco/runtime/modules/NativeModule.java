package marco.runtime.modules;

import marco.internal.Environment;
import marco.lang.MarcoFunction;
import marco.lang.MarcoModule;
import marco.lang.MarcoPort;
import marco.lang.functions.io.read_line;

import java.util.Arrays;

public class NativeModule extends MarcoModule {
    public NativeModule(Environment environment) {
        export("stdin", new MarcoPort(System.in));
        export("read-line", new MarcoFunction(environment, Arrays.asList("in"), new read_line()));
    }
}
