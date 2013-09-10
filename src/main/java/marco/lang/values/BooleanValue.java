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
    public MarcoObject activate(MarcoObject on) {
        throw new RuntimeException(this.getClass().getSimpleName() + "  can not be activated");
    }

    @Override
    public MarcoValue duplicate() {
        return new BooleanValue(value);
    }
}
