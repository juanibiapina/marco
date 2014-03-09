package marco.lang.especialforms;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.internal.bindings.ImmutableBinding;
import marco.lang.MarcoList;
import marco.lang.MarcoMacro;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;
import marco.lang.contracts.Contract;

public class def extends MarcoMacro {
    public def() {
        super(new Contract(2));
    }

    @Override
    public MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        String name = Cast.toSymbol(arguments.get(0)).getValue();

        ImmutableBinding binding = new ImmutableBinding(name, null);
        environment.add(binding);

        MarcoObject value = arguments.get(1).eval(environment);

        binding.redefine(value);

        return MarcoNil.NIL;
    }
}
