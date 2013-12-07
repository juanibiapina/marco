package marco.lang.functions;

import marco.internal.Environment;
import marco.lang.MarcoNativeObject;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;

public class print extends MarcoNativeObject {
    @Override
    public MarcoObject eval(Environment environment) {
        MarcoObject v = environment.lookUp("e");

        System.out.println(v);

        return MarcoNil.NIL;
    }
}
