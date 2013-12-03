package marco.lang;

import marco.internal.Environment;

public class MarcoBlock extends MarcoObject {
    private Environment closure;
    private MarcoObject value;

    public MarcoBlock(Environment closure, MarcoObject value) {
        this.closure = closure;
        this.value = value;
    }

    @Override
    public MarcoObject eval(Environment environment) {
        return value.eval(closure);
    }

    @Override
    public String typeName() {
        return "Block";
    }
}
