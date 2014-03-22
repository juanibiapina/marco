package marco.lang.functions;

import marco.internal.Environment;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;

public class print extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment environment) {
        MarcoObject v = environment.lookUp("e");

        System.out.println(v);

        return MarcoNil.NIL;
    }
}
