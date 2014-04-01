package marco.lang.especialforms;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.internal.bindings.LetBinding;
import marco.lang.*;
import marco.lang.contracts.Contract;

public class let extends MarcoSpecialForm {
    public let() {
        super(new Contract(2));
    }

    @Override
    public MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        Environment extendedEnv = environment.duplicate();

        MarcoList list = Cast.toList(arguments.get(0).eval(environment));

        String name = Cast.toSymbol(list.get(0)).getValue();

        LetBinding binding = new LetBinding(name, null);

        extendedEnv.forceAdd(binding);

        MarcoBlock block = Cast.toBlock(list.get(1).eval(extendedEnv));

        MarcoObject value = block.invoke(extendedEnv, environment);

        MarcoBlock body = Cast.toBlock(arguments.get(1).eval(environment));

        binding.redefine(value);

        return new MarcoContinuation(new MarcoBlockInvocation(body), extendedEnv, environment);
    }
}
