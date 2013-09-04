package marco.lang.values;

import marco.lang.MarcoObject;
import marco.lang.MarcoValue;

public class MessageValue implements MarcoValue {
    private String name;
    private MarcoObject cachedResult;
    private MarcoObject argument;

    public MessageValue(String name) {
        this.name = name;
    }

    @Override
    public MarcoObject activate(MarcoObject self, MarcoObject scope, MarcoObject on, MarcoObject message) {
        throw new RuntimeException(this.getClass().getSimpleName() + "  can not be activated");
    }

    @Override
    public MarcoValue duplicate() {
        return new MessageValue(name);
    }

    public void setCachedResult(MarcoObject cachedResult) {
        this.cachedResult = cachedResult;
    }

    public String getName() {
        return name;
    }

    public boolean hasCachedResult() {
        return cachedResult != null;
    }

    public MarcoObject getCachedResult() {
        return cachedResult;
    }

    public MarcoObject getArgument() {
        return argument;
    }

    public void setArgument(MarcoObject argument) {
        this.argument = argument;
    }
}
