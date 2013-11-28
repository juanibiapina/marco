package marco.lang.functions;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoNativeObject;
import marco.lang.MarcoNumber;
import marco.lang.MarcoObject;

public class plus extends MarcoNativeObject {
    @Override
    public MarcoObject eval(Environment environment) {
        MarcoNumber n1 = Cast.toNumber(environment.lookUp("v1"));
        MarcoNumber n2 = Cast.toNumber(environment.lookUp("v2"));

        return new MarcoNumber(n1.getValue() + n2.getValue());
    }
}
