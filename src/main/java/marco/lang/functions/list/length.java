package marco.lang.functions.list;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoList;
import marco.lang.MarcoNativeObject;
import marco.lang.MarcoNumber;
import marco.lang.MarcoObject;

public class length extends MarcoNativeObject {
    @Override
    public MarcoObject doEval(Environment environment, Environment global) {
        MarcoList list = Cast.toList(environment.lookUp("l"));

        return new MarcoNumber(list.length());
    }
}
