package marco.parser;

import marco.lang.MarcoObject;
import marco.lang.MarcoRuntime;

public class MarcoStringMessage implements MarcoMessage {
    private MarcoObject value;

    public MarcoStringMessage(MarcoRuntime runtime, String text) {
        value = runtime.createString(text);
    }

    @Override
    public MarcoObject eval(MarcoObject target) {
        return value;
    }
}
