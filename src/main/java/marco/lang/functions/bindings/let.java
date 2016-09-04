package marco.lang.functions.bindings;

import marco.lang.MarcoBlock;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;
import marco.lang.continuation.InvokeContinuation;
import marco.runtime.Cast;
import marco.runtime.Environment;
import marco.runtime.ListHelper;

import java.util.List;

public class let extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        List<MarcoObject> binding = ListHelper.toJavaList(closure.lookUp("binding"));
        MarcoBlock body = Cast.toBlock(closure.lookUp("body"));

        Environment extended = dynamic.spawn();

        String name = Cast.toSymbol(binding.get(0)).getValue();
        MarcoBlock block = Cast.toBlock(dynamic.getRuntime().eval(binding.get(1), extended));

        MarcoObject value = dynamic.getRuntime().invoke(block, extended, dynamic);

        extended.let(name, value);

        return new InvokeContinuation(body, extended, dynamic);
    }
}
