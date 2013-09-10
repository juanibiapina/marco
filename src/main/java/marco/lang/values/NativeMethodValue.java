package marco.lang.values;

import marco.lang.MarcoObject;
import marco.lang.MarcoValue;

public abstract class NativeMethodValue implements MarcoValue {
    @Override
    public MarcoObject activate(MarcoObject on) {
        return perform(on);
    }

    public abstract MarcoObject perform(MarcoObject self);

    public MarcoValue duplicate() {
        return this;
    }
}
