package marco.lang.values;

import marco.lang.MarcoValue;

public class NumberValue extends MarcoValue {
    private int value;

    public NumberValue(int value) {
        this.value = value;
    }

    public static MarcoValue fromString(String value) {
        return new NumberValue(Integer.parseInt(value));
    }
}
