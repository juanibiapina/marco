package marco.lang.functions.pairs;

import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;
import marco.lang.MarcoPair;
import marco.runtime.Cast;
import marco.runtime.Environment;

public class first extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoPair pair = Cast.toPair("Pair", closure.lookUp("pair"));

        return pair.getFirst();
    }
}
