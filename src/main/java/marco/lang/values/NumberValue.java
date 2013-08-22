package marco.lang.values;

import marco.lang.MarcoObject;
import marco.lang.MarcoValue;

public class NumberValue implements MarcoValue {
    private int value;

    public NumberValue(int value) {
        this.value = value;
    }

    public static MarcoValue fromString(String value) {
        return new NumberValue(Integer.parseInt(value));
    }

    @Override
    public MarcoValue duplicate() {
        return new NumberValue(value);
    }

    @Override
    public MarcoObject activate(MarcoObject owner) {
        return owner;
    }

    public int getValue() {
        return value;
    }
}
