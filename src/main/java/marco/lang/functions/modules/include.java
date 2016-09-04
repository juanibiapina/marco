package marco.lang.functions.modules;

import marco.runtime.Cast;
import marco.runtime.Environment;
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
