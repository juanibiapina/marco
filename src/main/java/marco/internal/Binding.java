package marco.internal;

import marco.lang.MarcoObject;

public class Binding {
    private MarcoObject value;

    public Binding(MarcoObject value) {
        this.value = value;
    }

    public MarcoObject getValue() {
        return value;
    }

    public void mutate(MarcoObject value) {
        this.value = value;
    }
}
