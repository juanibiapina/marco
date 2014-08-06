package marco.lang.functions.system;

import marco.runtime.Cast;
import marco.runtime.Environment;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoNumber;
import marco.lang.MarcoObject;

public class exit extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoNumber exitCode = Cast.toNumber(closure.lookUp("code"));

        System.exit(exitCode.getValue().intValue());

        return null;
    }
}
