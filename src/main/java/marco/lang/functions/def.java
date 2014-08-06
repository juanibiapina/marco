package marco.lang.functions;

import marco.runtime.Cast;
import marco.runtime.Environment;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;
import marco.lang.MarcoSymbol;

public class def extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoSymbol name = Cast.toSymbol(closure.lookUp("name"));
        MarcoObject value = closure.lookUp("value");

        dynamic.def(name.getValue(), value);

        return MarcoNil.NIL;
    }
}
