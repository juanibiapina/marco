package marco.lang;

import marco.runtime.Environment;

public abstract class MarcoNativeBlock extends MarcoBlock {
    public MarcoNativeBlock() {
        super(null);
    }

    @Override
    public abstract MarcoObject invoke(Environment closure, Environment dynamic);

}
