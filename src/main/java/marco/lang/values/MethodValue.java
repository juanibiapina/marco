package marco.lang.values;

import marco.lang.MarcoObject;
import marco.lang.MarcoValue;

public class MethodValue implements MarcoValue {
    @Override
    public MarcoObject activate(MarcoObject self, MarcoObject scope, MarcoObject on, MarcoObject message) {
        MarcoObject body = self.sendMessage(scope, "body");
        return self.runtime.interpreter.evalLine(scope, body);
    }

    @Override
    public MarcoValue duplicate() {
        return new MethodValue();
    }
}
