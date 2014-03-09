package marco.lang.especialforms;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.*;
import marco.lang.contracts.Contract;

public class if_specialform extends MarcoSpecialForm {
    public if_specialform() {
        super(new Contract(3));
    }

    @Override
    public MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        MarcoObject e1 = arguments.get(0);
        MarcoObject e2 = arguments.get(1);
        MarcoObject e3 = arguments.get(2);

        MarcoObject v1 = e1.eval(environment);

        if (Cast.toBoolean(v1) == MarcoBoolean.TRUE) {
            return new MarcoContinuation(e2, environment);
        } else {
            return new MarcoContinuation(e3, environment);
        }
    }
}
