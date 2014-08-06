package marco.lang.functions.booleans;

import marco.runtime.Cast;
import marco.runtime.Environment;
import marco.lang.*;

public class _if extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoObject condition = closure.lookUp("condition");
        MarcoBlock thenClause = Cast.toBlock(closure.lookUp("then-clause"));
        MarcoBlock elseClause = Cast.toBlock(closure.lookUp("else-clause"));

        if (Cast.toBoolean(condition) == MarcoBoolean.TRUE) {
            return thenClause.invoke(dynamic, dynamic);
        } else {
            return elseClause.invoke(dynamic, dynamic);
        }
    }
}
