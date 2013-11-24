package marco.lang;

import marco.internal.Environment;

public class MarcoNumber implements MarcoForm {
    private int value;

    public MarcoNumber(int value) {
        this.value = value;
    }

    @Override
    public MarcoObject eval(Environment environment) {
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MarcoNumber) {
            MarcoNumber other = (MarcoNumber) obj;
            return value == other.value;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    public int getValue() {
        return value;
    }
}
