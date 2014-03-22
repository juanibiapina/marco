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
        MarcoBlock thenClause = Cast.toBlock(arguments.get(1).eval(environment));
        MarcoBlock elseClause = Cast.toBlock(arguments.get(2).eval(environment));

        MarcoObject v1 = condition.eval(environment);

        if (Cast.toBoolean(v1) == MarcoBoolean.TRUE) {
            return new MarcoContinuation(new MarcoBlockInvocation(thenClause), environment, environment);
        } else {
            return new MarcoContinuation(new MarcoBlockInvocation(elseClause), environment, environment);
        }
    }
}
