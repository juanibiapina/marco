package marco.lang.especialforms;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.*;
import marco.lang.contracts.Contract;

public class and extends MarcoSpecialForm {
    public and() {
        super(new Contract(2));
    }

    @Override
    protected MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        MarcoObject e1 = arguments.get(0);
        MarcoObject e2 = arguments.get(1);

        if (Cast.toBoolean(e1.eval(environment)).equals(MarcoBoolean.TRUE)) {
            return new MarcoContinuation(e2, environment);
        } else {
            return MarcoBoolean.FALSE;
        }
    }
}
