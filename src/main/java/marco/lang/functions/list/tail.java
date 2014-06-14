package marco.lang.functions.list;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoList;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;

public class tail extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment environment) {
        MarcoList list = Cast.toList(closure.lookUp("list"));

        return list.getTail();
    }
}
