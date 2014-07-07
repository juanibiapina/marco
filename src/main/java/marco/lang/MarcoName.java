package marco.lang;

import marco.internal.Environment;
import marco.internal.bindings.Binding;
import marco.lang.error.LookUpError;

public class MarcoName extends MarcoObject {
    private String value;

    public MarcoName(String text) {
        this.value = text;
    }

    @Override
    public MarcoObject eval(Environment dynamic) {
        Binding binding = dynamic.get(value);
        if (binding.isEmpty()) {
            throw new LookUpError(dynamic.getRuntime(), fileName, startLine, value);
        }
        return binding.getValue();
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
    public String asString() {
        return toString();
    }
}
