package marco.lang.macros;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoList;
import marco.lang.MarcoNativeMacro;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;
import marco.lang.contracts.Contract;

public class def extends MarcoNativeMacro {
    public def() {
        super(new Contract(2));
    }

    @Override
    public MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        String name = Cast.toSymbol(arguments.get(0)).getValue();
        MarcoObject value = arguments.get(1).eval(environment);

        environment.def(name, value);

        return MarcoNil.NIL;
    }
}
