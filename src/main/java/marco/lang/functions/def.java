package marco.lang.functions;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.internal.bindings.ImmutableBinding;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;
import marco.lang.MarcoSymbol;

public class def extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment environment) {
        MarcoSymbol name = Cast.toSymbol(closure.lookUp("name"));
        MarcoObject value = closure.lookUp("value");

        ImmutableBinding binding = new ImmutableBinding(name.getValue(), value);
        environment.add(binding);

        return MarcoNil.NIL;
    }
}
