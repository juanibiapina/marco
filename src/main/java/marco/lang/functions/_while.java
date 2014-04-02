package marco.lang.functions;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.*;

public class _while extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment environment) {
        MarcoBlock cond = Cast.toBlock(closure.lookUp("cond"));
        MarcoBlock body = Cast.toBlock(closure.lookUp("body"));

        while (Cast.toBoolean(cond.invoke(environment, environment)) == MarcoBoolean.TRUE) {
            body.invoke(environment, environment);
        }

        return MarcoNil.NIL;
    }
}
