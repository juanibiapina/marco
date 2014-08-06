package marco.lang.functions.list;

import marco.runtime.Cast;
import marco.runtime.Environment;
import marco.lang.MarcoList;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;

public class tail extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoList list = Cast.toList(closure.lookUp("list"));

        return list.getTail();
    }
}
