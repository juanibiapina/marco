package marco.lang.functions;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoNativeObject;
import marco.lang.MarcoNumber;
import marco.lang.MarcoObject;

public class division extends MarcoNativeObject {
    @Override
    public MarcoObject eval(Environment environment) {
        MarcoNumber v1 = Cast.toNumber(environment.lookUp("v1"));
        MarcoNumber v2 = Cast.toNumber(environment.lookUp("v2"));

        return new MarcoNumber(v1.getValue() / v2.getValue());
    }
}
