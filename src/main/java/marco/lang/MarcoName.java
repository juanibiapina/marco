package marco.lang;

import marco.internal.Environment;

public class MarcoName extends MarcoObject {
    private String value;

    public MarcoName(String text) {
        this.value = text;
    }

    @Override
    public MarcoObject doEval(Environment closure, Environment environment) {
        return closure.lookUp(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MarcoName) {
            MarcoName other = (MarcoName) obj;
            return value.equals(other.value);
        } else {
            return false;
        }
    }

    @Override
    public String typeName() {
        return "Name";
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public String toString() {
        return "'" + value;
    }

    @Override
    public boolean isContinuation() {
        return false;
    }

    @Override
    public String asString() {
        return toString();
    }
}
