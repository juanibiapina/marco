package marco.lang.functions;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoNativeObject;
import marco.lang.MarcoNumber;
import marco.lang.MarcoObject;

public class exit extends MarcoNativeObject {
    @Override
    protected MarcoObject doEval(Environment environment) {
        MarcoNumber exitCode = Cast.toNumber(environment.lookUp("code"));

        System.exit(exitCode.getValue().intValue());

        return null;
    }
}
