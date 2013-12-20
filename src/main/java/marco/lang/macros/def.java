package marco.lang.macros;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoList;
import marco.lang.MarcoMacro;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;
import marco.lang.contracts.Contract;

public class def extends MarcoMacro {
    public def() {
        super(new Contract(2));
    }

    @Override
    public MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        String name = Cast.toSymbol(arguments.get(0)).getValue();

        environment.predefine(name);

        MarcoObject value = arguments.get(1).eval(environment);

        environment.redefine(name, value);

        return MarcoNil.NIL;
    }
}
