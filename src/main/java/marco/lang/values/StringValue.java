package marco.lang.values;

import marco.lang.MarcoObject;
import marco.lang.MarcoValue;

public class StringValue implements MarcoValue {
    private String value;

    public StringValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public MarcoObject activate(MarcoObject on) {
        throw new RuntimeException(this.getClass().getSimpleName() + "  can not be activated");
    }

    @Override
    public MarcoValue duplicate() {
        return new StringValue(value);
    }
}
