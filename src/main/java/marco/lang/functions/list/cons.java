package marco.lang.functions.list;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoCons;
import marco.lang.MarcoList;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;

public class cons extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment environment) {
        MarcoObject head = closure.lookUp("head");
        MarcoList tail = Cast.toList(closure.lookUp("tail"));

        return new MarcoCons(head, tail);
    }
}
