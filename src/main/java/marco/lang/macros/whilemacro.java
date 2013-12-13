package marco.lang.macros;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.*;
import marco.lang.contracts.Contract;

public class whilemacro extends MarcoNativeMacro {
    public whilemacro() {
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
