package marco.lang.macros;

import marco.internal.Environment;
import marco.lang.MarcoList;
import marco.lang.MarcoNativeMacro;
import marco.lang.MarcoObject;

public class quote extends MarcoNativeMacro {
    @Override
    public MarcoObject call(Environment environment, MarcoList arguments) {
        assertArity(1, arguments.size());

        MarcoObject arg = arguments.get(0);

        return arg;
    }
}
