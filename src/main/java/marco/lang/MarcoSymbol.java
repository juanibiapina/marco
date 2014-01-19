package marco.lang;

import marco.internal.Environment;

import java.util.Arrays;
import java.util.List;

public class MarcoSymbol extends MarcoObject {
    private String value;

    public MarcoSymbol(String text) {
        this.value = text;
    }

    @Override
    public MarcoObject eval(Environment environment) {
        return environment.lookUp(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MarcoSymbol) {
            MarcoSymbol other = (MarcoSymbol) obj;
            return value.equals(other.value);
        } else {
            return false;
        }
    }

    @Override
    public String typeName() {
        return "Symbol";
    }

    @Override
    public List<String> freeVariables() {
        return Arrays.asList(value);
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public String toString() {
        return "'" + value;
    }
}
