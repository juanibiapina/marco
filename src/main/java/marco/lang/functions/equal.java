package marco.lang.functions;

import marco.internal.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoNativeObject;
import marco.lang.MarcoObject;

public class equal extends MarcoNativeObject {
    @Override
    public MarcoObject eval(Environment environment) {
        MarcoObject v1 = environment.lookUp("v1");
        MarcoObject v2 = environment.lookUp("v2");

        return v1.equal(v2);
    }
}
