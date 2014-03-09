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
        MarcoObject condition = arguments.get(0);
        MarcoObject thenClause = arguments.get(1);
        MarcoObject elseClause = arguments.get(2);

        MarcoObject v1 = condition.eval(environment);

        if (Cast.toBoolean(v1) == MarcoBoolean.TRUE) {
            return new MarcoContinuation(thenClause, environment);
        } else {
            return new MarcoContinuation(elseClause, environment);
        }
    }
}
