package marco.runtime.modules;

import marco.runtime.Environment;
import marco.lang.MarcoFunction;
import marco.lang.MarcoModule;
import marco.lang.MarcoPort;
import marco.lang.functions.io.read_line;

import java.util.Arrays;

public class NativeIOModule extends MarcoModule {
    public NativeIOModule(Environment environment) {
        export("stdin", new MarcoPort(System.in));
        export("read-line", new MarcoFunction(environment, Arrays.asList("in"), new read_line()));
    }
}
