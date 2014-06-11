package marco.internal.bindings;

import marco.lang.MarcoObject;

public abstract class Binding {
    private String symbol;
    private MarcoObject value;

    public Binding(String symbol, MarcoObject value) {
        this.symbol = symbol;
        this.value = value;
    }

    public MarcoObject getValue() {
        return value;
    }

    protected void setValue(MarcoObject value) {
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract void mutate(MarcoObject value);
}
