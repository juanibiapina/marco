package marco.lang;

import marco.MarcoException;
import marco.lang.types.Message;

public class MarcoObject {
    private MarcoValue value;
    private MarcoObject parent;
    private String name;

    public MarcoObject(MarcoRuntime runtime) {

    }

    public MarcoObject sendMessage(MarcoObject message) {
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
        return name;
    }

    public void setValue(MarcoValue value) {
        this.value = value;
    }

    public MarcoValue getValue() {
        return value;
    }
}
