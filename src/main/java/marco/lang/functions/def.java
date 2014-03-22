package marco.lang.functions;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.internal.bindings.ImmutableBinding;
import marco.lang.MarcoNativeObject;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;
import marco.lang.MarcoSymbol;

public class def extends MarcoNativeObject {
    @Override
    protected MarcoObject doEval(Environment environment, Environment global) {
        MarcoSymbol name = Cast.toSymbol(environment.lookUp("name"));
        MarcoObject value = environment.lookUp("value");

        ImmutableBinding binding = new ImmutableBinding(name.getValue(), value);
        global.add(binding);

        return MarcoNil.NIL;
    }
}
