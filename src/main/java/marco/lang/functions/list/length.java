package marco.lang.functions.list;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoList;
import marco.lang.MarcoNativeObject;
import marco.lang.MarcoNumber;
import marco.lang.MarcoObject;

public class length extends MarcoNativeObject {
    @Override
    public MarcoObject eval(Environment environment) {
        MarcoList list = Cast.toList(environment.lookUp("l"));

        return new MarcoNumber(list.length());
    }
}
