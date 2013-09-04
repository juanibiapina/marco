package marco.lang.values;

import marco.lang.MarcoObject;
import marco.lang.MarcoValue;

public abstract class NativeMethodValue implements MarcoValue {
    @Override
    public MarcoObject activate(MarcoObject self, MarcoObject scope, MarcoObject on, MarcoObject message) {
        return perform(scope, on, message);
    }

    public abstract MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message);

    public MarcoValue duplicate() {
        return this;
    }
}
