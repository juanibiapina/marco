package marco.lang.macros;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.internal.bindings.LetBinding;
import marco.lang.MarcoList;
import marco.lang.MarcoMacro;
import marco.lang.MarcoObject;
import marco.lang.contracts.Contract;

public class let extends MarcoMacro {
    public let() {
        super(new Contract(2));
    }

    @Override
    public MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        Environment extendedEnv = environment.duplicate();

        MarcoList list = Cast.toList(arguments.get(0));

        String name = Cast.toSymbol(list.get(0)).getValue();

        LetBinding binding = new LetBinding(name, null);

        extendedEnv.forceAdd(binding);

        MarcoObject value = list.get(1).eval(extendedEnv);

        MarcoObject body = arguments.get(1);

        binding.redefine(value);

        return body.eval(extendedEnv);
    }
}
