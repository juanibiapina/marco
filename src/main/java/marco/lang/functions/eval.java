package marco.lang.functions;

import marco.internal.Environment;
import marco.lang.MarcoNativeObject;
import marco.lang.MarcoObject;

public class eval extends MarcoNativeObject {
    @Override
    public MarcoObject eval(Environment environment) {
        MarcoObject arg = environment.lookUp("arg");

        return arg.eval(environment);
    }
}
