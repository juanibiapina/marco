package marco.parser;

import marco.lang.MarcoObject;
import marco.lang.MarcoRuntime;

public class MarcoNumberMessage extends MarcoMessage {
    private MarcoObject value;

    public MarcoNumberMessage(MarcoRuntime runtime, String text) {
        value = runtime.createNumber(text);
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
