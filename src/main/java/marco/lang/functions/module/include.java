package marco.lang.functions.module;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.*;

public class include extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoString moduleName = Cast.toString(closure.lookUp("module-name"));

        MarcoModule module = dynamic.getRuntime().loadModule(moduleName.getValue());
        module.include(dynamic);

        return MarcoNil.NIL;
    }
}
