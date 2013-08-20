package marco.lang;

import marco.MarcoException;
import marco.lang.helpers.Cast;
import marco.lang.types.Message;

public class MarcoObject {
    public MarcoRuntime runtime;
    private String name;
    private MarcoValue value;
    private MarcoObject parent;

    public MarcoObject(MarcoRuntime runtime) {
        this.runtime = runtime;
    }

    public MarcoObject sendMessage(MarcoObject message) {
        if (Cast.toBoolean(Message.hasCachedResult(message))) {
            return Message.getCachedResult(message);
        }

        String slotName = Message.name(message);
        throw new MarcoException("Exception: " + getName() + " does not respond to " + slotName);
    }

    public void setParent(MarcoObject parent) {
        this.parent = parent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        if (hasName()) {
            return name;
        } else {
            return parent.getName();
        }
    }

    private boolean hasName() {
        return name != null;
    }

    public void setValue(MarcoValue value) {
        this.value = value;
    }

    public MarcoValue getValue() {
        return value;
    }
}
