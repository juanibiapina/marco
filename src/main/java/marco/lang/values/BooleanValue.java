package marco.lang.values;

import marco.lang.MarcoValue;

public class BooleanValue extends MarcoValue {
    private boolean value;

    public BooleanValue(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }
}
