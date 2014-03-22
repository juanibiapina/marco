package marco.lang.functions;

import marco.internal.Environment;
import marco.lang.MarcoNativeObject;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;

public class print extends MarcoNativeObject {
    @Override
    public MarcoObject doEval(Environment environment, Environment global) {
        MarcoObject v = environment.lookUp("e");

        System.out.println(v);

        return MarcoNil.NIL;
    }
}
