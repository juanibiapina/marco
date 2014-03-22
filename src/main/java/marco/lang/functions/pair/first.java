package marco.lang.functions.pair;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;
import marco.lang.MarcoPair;

public class first extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment environment) {
        MarcoPair pair = Cast.toPair(closure.lookUp("pair"));

        return pair.getFirst();
    }
}
