package marco.lang.functions.control_flow;

import marco.runtime.Cast;
import marco.runtime.Environment;
import marco.lang.*;

public class _while extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoBlock cond = Cast.toBlock(closure.lookUp("cond"));
        MarcoBlock body = Cast.toBlock(closure.lookUp("body"));

        while (Cast.toBoolean(dynamic.getRuntime().invoke(cond, dynamic, dynamic)) == MarcoBoolean.TRUE) {
            dynamic.getRuntime().invoke(body, dynamic, dynamic);
        }

        return MarcoNil.NIL;
    }
}
