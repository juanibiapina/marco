package marco.lang.functions.module;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;
import marco.lang.MarcoString;

public class require_native extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoString moduleName = Cast.toString(closure.lookUp("module-name"));

        return closure.getRuntime().loadNativeModule(moduleName.getValue());
    }
}
