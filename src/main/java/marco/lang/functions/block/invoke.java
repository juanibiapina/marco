package marco.lang.functions.block;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoBlock;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;

public class invoke extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoBlock block = Cast.toBlock(closure.lookUp("block"));

        return block.invoke(closure, dynamic);
    }
}