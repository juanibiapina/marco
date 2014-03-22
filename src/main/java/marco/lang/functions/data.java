package marco.lang.functions;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoData;
import marco.lang.MarcoList;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;

public class data extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment environment) {
        MarcoList fields = Cast.toList(environment.lookUp("fields"));

        return new MarcoData(fields);
    }
}
