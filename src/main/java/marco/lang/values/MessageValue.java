package marco.lang.values;

import marco.lang.MarcoObject;
import marco.lang.MarcoValue;

public class MessageValue implements MarcoValue {
    private String name;
    private MarcoObject cachedResult;

    public MessageValue(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCachedResult(MarcoObject result) {
        cachedResult = result;
    }

    public boolean hasCachedResult() {
        return cachedResult != null;
    }

    public MarcoObject getCachedResult() {
        return cachedResult;
    }

    @Override
    public MarcoValue duplicate() {
        return new MessageValue(name); // TODO: what about cached results ?
    }

    @Override
    public MarcoObject activate(MarcoObject owner) {
        return owner;
    }
}
