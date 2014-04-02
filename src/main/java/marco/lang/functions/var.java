package marco.lang.functions;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;

public class var extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment environment) {
        String name = Cast.toSymbol(closure.lookUp("name")).getValue();
        MarcoObject value = closure.lookUp("value");

        environment.var(name, value);

        return MarcoNil.NIL;
    }
}
