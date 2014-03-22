package marco.lang.especialforms;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.*;
import marco.lang.contracts.Contract;

public class or extends MarcoSpecialForm {
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
            return new MarcoContinuation(e2, environment, environment);
        }
    }
}
