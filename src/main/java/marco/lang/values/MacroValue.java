package marco.lang.values;

import marco.lang.MarcoObject;
import marco.lang.MarcoValue;

public class MacroValue implements MarcoValue {
    private MarcoObject body;

    public MacroValue() {
    }

    public MacroValue(MarcoObject body) {
        this.body = body;
    }

    @Override
    public MarcoObject activate(MarcoObject self, MarcoObject scope, MarcoObject on, MarcoObject message) {
        if (body != null) {
            return on.runtime.interpreter.eval(scope, body);
        } else {
            throw new RuntimeException("Trying to activate empty macro");
        }
    }

    @Override
    public MarcoValue duplicate() {
        return new MacroValue(body);
    }
}
