package marco.lang.functions.data;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoData;
import marco.lang.MarcoList;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;

public class data extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoList fields = Cast.toList(closure.lookUp("fields"));

        return new MarcoData(fields);
    }
}
