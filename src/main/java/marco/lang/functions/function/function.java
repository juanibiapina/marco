package marco.lang.functions.function;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.*;

public class function extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoList formal = Cast.toList(closure.lookUp("formal"));
        MarcoBlock body = Cast.toBlock(closure.lookUp("body"));

        return new MarcoFunction(dynamic, formal.asArgumentList(), body);
    }
}
