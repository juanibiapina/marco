package marco.lang.especialforms;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoList;
import marco.lang.MarcoMacro;
import marco.lang.MarcoObject;
import marco.lang.contracts.Contract;

public class and extends MarcoMacro {
    public and() {
        super(new Contract(2));
    }

    @Override
    protected MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        MarcoObject e1 = arguments.get(0);
        MarcoObject e2 = arguments.get(1);

        if (Cast.toBoolean(e1.eval(environment)).equals(MarcoBoolean.TRUE)) {
            return e2.eval(environment);
        } else {
            return MarcoBoolean.FALSE;
        }
    }
}
