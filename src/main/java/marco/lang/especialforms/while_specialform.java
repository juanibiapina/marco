package marco.lang.especialforms;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.*;
import marco.lang.contracts.Contract;

public class while_specialform extends MarcoSpecialForm {
    public while_specialform() {
        super(new Contract(2));
    }

    @Override
    protected MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        MarcoObject cond = arguments.get(0);
        MarcoObject body = arguments.get(1);

        while (Cast.toBoolean(cond.eval(environment)) == MarcoBoolean.TRUE) {
            body.eval(environment);
        }

        return MarcoNil.NIL;
    }
}
