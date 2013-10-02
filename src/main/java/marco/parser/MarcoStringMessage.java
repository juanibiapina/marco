package marco.parser;

import marco.lang.MarcoObject;
import marco.lang.MarcoRuntime;

public class MarcoStringMessage extends MarcoMessage {
    private MarcoObject value;

    public MarcoStringMessage(MarcoRuntime runtime, String text) {
        value = runtime.createString(text);
    }

    @Override
    public boolean hasCachedValue() {
        return true;
    }

    @Override
    public MarcoObject getCachedValue() {
        return value;
    }

    @Override
    public String getName() {
        throw new RuntimeException("Error");
    }
}
