package marco.lang;

import marco.internal.Environment;

public abstract class MarcoNativeBlock extends MarcoBlock {
    public MarcoNativeBlock() {
        super(null);
    }

    @Override
    public String typeName() {
        return "NativeBlock";
    }

    @Override
    public abstract MarcoObject invoke(Environment closure, Environment dynamic);

    @Override
    public boolean isList() {
        return false;
    }

}
