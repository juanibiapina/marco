package marco.lang.macros;

import marco.internal.Environment;
import marco.lang.*;
import marco.internal.Cast;

import java.util.List;

public class setbang extends MarcoNativeMacro {
    @Override
    public MarcoObject call(Environment environment, List<MarcoForm> arguments) {
        assertArity(2, arguments.size());

        MarcoSymbol var = Cast.toSymbol(arguments.get(0));
        MarcoObject value = arguments.get(1).eval(environment);

        environment.mutate(var.getValue(), value);

        return MarcoNil.NIL;
    }
}
