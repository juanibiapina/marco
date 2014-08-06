package marco.lang.functions;

import marco.runtime.Cast;
import marco.runtime.Environment;
import marco.lang.*;

public class let extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoList binding = Cast.toList(closure.lookUp("binding"));
        MarcoBlock body = Cast.toBlock(closure.lookUp("body"));

        Environment extended = dynamic.spawn();

        String name = Cast.toSymbol(binding.get(0)).getValue();
        MarcoBlock block = Cast.toBlock(binding.get(1).eval(extended));

        MarcoObject value = block.invoke(extended, dynamic);

        extended.let(name, value);

        return body.invoke(extended, dynamic);
    }
}
