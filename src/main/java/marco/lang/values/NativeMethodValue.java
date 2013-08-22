package marco.lang.values;

import marco.lang.MarcoObject;
import marco.lang.MarcoValue;

public abstract class NativeMethodValue implements MarcoValue {
    @Override
    public MarcoValue duplicate() {
        return this;
    }

    @Override
    public MarcoObject activate(MarcoObject owner) {
        return perform(owner);
    }

    public abstract MarcoObject perform(MarcoObject self);
}
