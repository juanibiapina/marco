package marco.lang;

public class MarcoString extends MarcoValue {
    private String value;

    public MarcoString(String text) {
        this.value = text;
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
    public String convertToString() {
        return value;
    }

    @Override
    protected MarcoObject _clone() {
        return new MarcoString(value);
    }

    public String getValue() {
        return value;
    }
}
