package marco.lang;

import marco.internal.Environment;

public class MarcoString extends MarcoForm {
    private String value;

    public MarcoString(String text) {
        this.value = text;
    }

    @Override
    public MarcoObject eval(Environment environment) {
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MarcoString) {
            MarcoString other = (MarcoString) obj;
            return value.equals(other.value);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "\"" + value + "\"";
    }

    @Override
    public String typeName() {
        return "String";
    }
}
