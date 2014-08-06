package marco.lang.functions;

import marco.runtime.Cast;
import marco.runtime.Environment;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;

public class var extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        String name = Cast.toSymbol(closure.lookUp("name")).getValue();
        MarcoObject value = closure.lookUp("value");

        dynamic.var(name, value);

        return MarcoNil.NIL;
    }
}
