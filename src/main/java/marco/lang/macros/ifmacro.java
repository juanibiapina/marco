package marco.lang.macros;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoList;
import marco.lang.MarcoNativeMacro;
import marco.lang.MarcoObject;

public class ifmacro extends MarcoNativeMacro {
    @Override
    public MarcoObject call(Environment environment, MarcoList arguments) {
        assertArity(3, arguments.size());

        MarcoObject e1 = arguments.get(0);
        MarcoObject e2 = arguments.get(1);
        MarcoObject e3 = arguments.get(2);

        MarcoObject v1 = e1.eval(environment);

        if (Cast.toBoolean(v1) == MarcoBoolean.TRUE) {
            return e2.eval(environment);
        } else {
            return e3.eval(environment);
        }
    }
}
