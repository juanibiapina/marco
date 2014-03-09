package marco.lang.especialforms;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoList;
import marco.lang.MarcoMacro;
import marco.lang.MarcoObject;
import marco.lang.contracts.Contract;

public class ifmacro extends MarcoMacro {
    public ifmacro() {
        super(new Contract(3));
    }

    @Override
    public MarcoObject performInvoke(Environment environment, MarcoList arguments) {
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
