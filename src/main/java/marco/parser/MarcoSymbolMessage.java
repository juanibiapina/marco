package marco.parser;

import marco.lang.MarcoObject;

public class MarcoSymbolMessage extends MarcoMessage {
    private String value;

    public MarcoSymbolMessage(String text) {
        this.value = text;
    }

    @Override
    public boolean hasCachedValue() {
        return false;
    }

    @Override
    public MarcoObject getCachedValue() {
        throw new RuntimeException("Error");
    }

    @Override
    public String getName() {
        return value;
    }
}
