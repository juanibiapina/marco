package marco.lang.macros;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoList;
import marco.lang.MarcoNativeMacro;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;

public class var extends MarcoNativeMacro {
    @Override
    public MarcoObject call(Environment environment, MarcoList arguments) {
        assertArity(2, arguments.size());

        String name = Cast.toSymbol(arguments.get(0)).getValue();
        MarcoObject value = arguments.get(1).eval(environment);

        environment.var(name, value);

        return MarcoNil.NIL;
    }
}
