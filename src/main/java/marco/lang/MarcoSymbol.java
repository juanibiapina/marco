package marco.lang;

public class MarcoSymbol extends MarcoValue {
    private String value;

    public MarcoSymbol(String value) {
        this.value = value;
    }

    @Override
    public String typeName() {
        return "Symbol";
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public String asString() {
        return toString();
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

    public String getValue() {
        return value;
    }
}
