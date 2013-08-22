package marco.lang.values;

import marco.lang.MarcoValue;

public class StringValue implements MarcoValue {
    private String value;

    public StringValue(String value) {
        this.value = value;
    }

    @Override
    public MarcoValue duplicate() {
        return new StringValue(value);
    }
}
