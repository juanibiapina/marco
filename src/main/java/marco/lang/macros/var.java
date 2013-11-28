package marco.lang.macros;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoNativeMacro;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;

import java.util.List;

public class var extends MarcoNativeMacro {
    @Override
    public MarcoObject call(Environment environment, List<MarcoObject> arguments) {
        assertArity(2, arguments.size());

        String name = Cast.toSymbol(arguments.get(0)).getValue();
        MarcoObject value = arguments.get(1).eval(environment);

        environment.bindVar(name, value);

        return MarcoNil.NIL;
    }
}
