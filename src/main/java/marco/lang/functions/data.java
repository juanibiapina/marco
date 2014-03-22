package marco.lang.functions;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoData;
import marco.lang.MarcoList;
import marco.lang.MarcoNativeObject;
import marco.lang.MarcoObject;

public class data extends MarcoNativeObject {
    @Override
    protected MarcoObject doEval(Environment environment, Environment global) {
        MarcoList fields = Cast.toList(environment.lookUp("fields"));

        return new MarcoData(fields);
    }
}
