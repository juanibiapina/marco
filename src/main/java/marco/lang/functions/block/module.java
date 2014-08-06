package marco.lang.functions.block;

import marco.runtime.Cast;
import marco.runtime.Environment;
import marco.lang.MarcoBlock;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;

public class module extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoBlock block = Cast.toBlock(closure.lookUp("block"));

        return block.module(closure.getRuntime());
    }
}
