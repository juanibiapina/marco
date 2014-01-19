package marco.lang.functions.pair;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoNativeObject;
import marco.lang.MarcoObject;
import marco.lang.MarcoPair;

public class first extends MarcoNativeObject {
    @Override
    public MarcoObject eval(Environment environment) {
        MarcoPair pair = Cast.toPair(environment.lookUp("pair"));

        return pair.getFirst();
    }
}
