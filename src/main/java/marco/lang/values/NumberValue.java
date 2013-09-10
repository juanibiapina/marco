package marco.lang.values;

import marco.lang.MarcoObject;
import marco.lang.MarcoValue;

public class NumberValue implements MarcoValue {
    private int value;

    public NumberValue(int value) {
        this.value = value;
    }

    public NumberValue(String value) {
        this.value = Integer.parseInt(value);
    }

    @Override
    public MarcoObject activate(MarcoObject on) {
        throw new RuntimeException(this.getClass().getSimpleName() + "  can not be activated");
    }

    @Override
    public MarcoValue duplicate() {
        return new NumberValue(value);
    }

    public int getValue() {
        return value;
    }
}
