package marco.lang.functions.function;

import marco.lang.MarcoBlock;
import marco.lang.MarcoFunction;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;
import marco.runtime.Cast;
import marco.runtime.Environment;
import marco.runtime.ListHelper;

import java.util.List;

public class function extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        List<String> args = ListHelper.asArgumentList(closure.lookUp("formal"));
        MarcoBlock body = Cast.toBlock(closure.lookUp("body"));

        return new MarcoFunction(dynamic, args, body);
    }
}
