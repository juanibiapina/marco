package marco.lang.functions.booleans;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.*;

public class _if extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment environment) {
        MarcoObject condition = closure.lookUp("condition");
        MarcoBlock thenClause = Cast.toBlock(closure.lookUp("then-clause"));
        MarcoBlock elseClause = Cast.toBlock(closure.lookUp("else-clause"));

        if (Cast.toBoolean(condition) == MarcoBoolean.TRUE) {
            return new MarcoContinuation(new MarcoBlockInvocation(thenClause), environment, environment);
        } else {
            return new MarcoContinuation(new MarcoBlockInvocation(elseClause), environment, environment);
        }
    }
}
