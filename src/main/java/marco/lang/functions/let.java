package marco.lang.functions;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.internal.bindings.LetBinding;
import marco.lang.*;

public class let extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment environment) {
        MarcoList binding = Cast.toList(closure.lookUp("binding"));
        MarcoBlock body = Cast.toBlock(closure.lookUp("body"));

        String name = Cast.toSymbol(binding.get(0)).getValue();

        Environment extendedEnv = environment.duplicate();

        LetBinding letBinding = new LetBinding(name, null);

        extendedEnv.addSlot(letBinding);

        MarcoBlock block = Cast.toBlock(binding.get(1).eval(extendedEnv));

        MarcoObject value = block.invoke(extendedEnv, environment);

        letBinding.redefine(value);

        return new MarcoContinuation(new MarcoBlockInvocation(body), extendedEnv, environment);
    }
}
