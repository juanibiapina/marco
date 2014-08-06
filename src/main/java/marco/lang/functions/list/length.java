package marco.lang.functions.list;

import marco.runtime.Cast;
import marco.runtime.Environment;
import marco.lang.MarcoList;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoNumber;
import marco.lang.MarcoObject;

public class length extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoList list = Cast.toList(closure.lookUp("l"));

        return new MarcoNumber(list.length());
    }
}
