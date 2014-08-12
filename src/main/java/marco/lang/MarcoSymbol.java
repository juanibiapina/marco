package marco.lang;

public class MarcoSymbol extends MarcoValue {
    private String value;

    public MarcoSymbol(String value) {
        this.value = value;
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public String convertToString() {
        return ":" + value;
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
    public int hashCode() {
        return value.hashCode();
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return convertToString();
    }
}
