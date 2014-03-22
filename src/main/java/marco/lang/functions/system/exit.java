package marco.lang.functions.system;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoNumber;
import marco.lang.MarcoObject;

public class exit extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment environment) {
        MarcoNumber exitCode = Cast.toNumber(closure.lookUp("code"));

        System.exit(exitCode.getValue().intValue());

        return null;
    }
}
