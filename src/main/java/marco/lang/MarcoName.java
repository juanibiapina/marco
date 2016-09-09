package marco.lang;

import marco.runtime.Environment;
import marco.runtime.bindings.Binding;
import marco.lang.error.LookUpError;

public class MarcoName extends MarcoObject {
    private String value;

    public MarcoName(String text) {
        this.value = text;
    }

    @Override
    public MarcoObject __eval(Environment dynamic) {
        Binding binding = dynamic.get(value);
        if (binding.isEmpty()) {
            throw new LookUpError(getFileName(), getStartLine(), value);
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
    public String convertToString() {
        return value;
    }

    @Override
    protected MarcoObject _clone() {
        return new MarcoName(value);
    }
}
