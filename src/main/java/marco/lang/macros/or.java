package marco.lang.macros;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoList;
import marco.lang.MarcoMacro;
import marco.lang.MarcoObject;
import marco.lang.contracts.Contract;

public class or extends MarcoMacro {
    public or() {
        super(new Contract(2));
    }

    @Override
    protected MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        MarcoObject e1 = arguments.get(0);
        MarcoObject e2 = arguments.get(1);

        MarcoObject v1 = e1.eval(environment);

        if (Cast.toBoolean(v1).equals(MarcoBoolean.TRUE)) {
            return v1;
        } else {
            return e2.eval(environment);
        }
    }
}
