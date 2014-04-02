package marco.lang.functions;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.internal.bindings.Binding;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;
import marco.lang.MarcoSymbol;

public class setbang extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment environment) {
        MarcoSymbol name = Cast.toSymbol(closure.lookUp("name"));
        MarcoObject value = closure.lookUp("value");

        Binding binding = environment.get(name.getValue());
        binding.mutate(value);

        return MarcoNil.NIL;
    }
}
