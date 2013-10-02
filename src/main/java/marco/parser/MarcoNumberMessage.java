package marco.parser;

import marco.lang.MarcoObject;
import marco.lang.MarcoRuntime;

public class MarcoNumberMessage implements MarcoMessage {
    private MarcoObject value;

    public MarcoNumberMessage(MarcoRuntime runtime, String text) {
        value = runtime.createNumber(text);
    }

    @Override
    public MarcoObject eval(MarcoObject target) {
        return value;
    }
}
