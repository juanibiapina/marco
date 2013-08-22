package marco.lang.values;

import marco.lang.MarcoObject;
import marco.lang.MarcoValue;

public class BooleanValue implements MarcoValue {
    private boolean value;

    public BooleanValue(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public MarcoValue duplicate() {
        return new BooleanValue(value);
    }

    @Override
    public MarcoObject activate(MarcoObject owner) {
        return owner;
    }
}
