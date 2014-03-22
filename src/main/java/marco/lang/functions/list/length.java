package marco.lang.functions.list;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoList;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoNumber;
import marco.lang.MarcoObject;

public class length extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment environment) {
        MarcoList list = Cast.toList(environment.lookUp("l"));

        return new MarcoNumber(list.length());
    }
}
