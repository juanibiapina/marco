package marco.lang.functions.function;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.*;

public class function extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment environment) {
        MarcoList formal = Cast.toList(environment.lookUp("formal"));
        MarcoBlock body = Cast.toBlock(environment.lookUp("body"));

        return new MarcoFunction(environment.getEnclosing(), formal.asArgumentList(), body);
    }
}
